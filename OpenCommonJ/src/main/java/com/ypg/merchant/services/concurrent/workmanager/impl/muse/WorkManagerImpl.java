package com.ypg.merchant.services.concurrent.workmanager.impl.muse;

//import EDU.oswego.cs.dl.util.concurrent.OswegoThreadPool;
import commonj.work.Work;
import commonj.work.WorkEvent;
import commonj.work.WorkException;
import commonj.work.WorkItem;
import commonj.work.WorkListener;
import commonj.work.WorkManager;
import commonj.work.WorkRejectedException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ypg.merchant.services.concurrent.i18n.Keys;
import com.ypg.merchant.services.concurrent.i18n.Messages;
import com.ypg.merchant.services.concurrent.i18n.MessagesImpl;
import com.ypg.merchant.services.concurrent.workmanager.ext.OswegoThreadPool;
import com.ypg.merchant.services.concurrent.workmanager.ext.ThreadPool;
import com.ypg.merchant.services.concurrent.workmanager.ext.WorkEventHelper;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

public class WorkManagerImpl
implements WorkManager
{
private static final Log LOG = LogFactory.getLog( WorkManagerImpl.class );

/** DOCUMENT_ME */
public static final Messages MSG = MessagesImpl.getInstance(  );

/**
 * DOCUMENT_ME
 */
protected static final int MAX_POOL_SIZE = 5;
private ThreadPool     pool;
private Map<Work,WorkItem>                workItems = new HashMap<Work,WorkItem>(  );

/**
 * Creates a new {@link WorkManagerImpl} object.
 */
public WorkManagerImpl(  )
{
   this( MAX_POOL_SIZE );
}

/**
 * Creates a new {@link WorkManagerImpl} object.
 *
 * @param maxPoolSize DOCUMENT_ME
 */
public WorkManagerImpl( int maxPoolSize )
{
   LOG.debug( MSG.getMessage( Keys.CREATE_WRK_MGR_POOL_SZE,
                              Integer.toString( maxPoolSize ) ) );
   this.pool = new OswegoThreadPool( maxPoolSize );
}

/**
 * DOCUMENT_ME
 *
 * @param maxPoolSize DOCUMENT_ME
 */
public void setMaxThreads( int maxPoolSize )
{
   LOG.debug( MSG.getMessage( Keys.WRK_MGR_POOL_SIZE,
                              Integer.toString( maxPoolSize ) ) );
   this.pool.setMaxThreads( maxPoolSize );
}

/**
 * DOCUMENT_ME
 *
 * @return DOCUMENT_ME
 */
public int getMaxThreads(  )
{
   return this.pool.getMaxThreads();
}

/* (non-Javadoc)
 * @see commonj.work.WorkManager#schedule(commonj.work.Work, commonj.work.WorkListener)
 */
public synchronized WorkItem schedule( Work         work,
                                       WorkListener listener )
throws WorkException, 
       IllegalArgumentException
{
   WorkEvent event;

   if ( work == null )
   {
      throw new IllegalArgumentException( MSG.getMessage( Keys.NULL_WORK ) );
   }

   WorkItem workItem = new WorkItemImpl( work );

   this.workItems.put( work, workItem );

   try
   {
      if ( work.isDaemon(  ) )
      {
         Thread thread = new Thread( new WorkWrapper( work, listener ) );
         thread.setDaemon( true );
         thread.start(  );
      }
      else
      {
         this.pool.execute( new WorkWrapper( work, listener ) );
      }
   }
   catch ( Exception e )
   {
      event = new WorkEventImpl( WorkEvent.WORK_REJECTED, workItem );
      this.processEvent( event );
      if ( listener != null )
      {
         listener.workRejected( event );
      }

      throw new WorkRejectedException( e );
   }

   event = new WorkEventImpl( WorkEvent.WORK_ACCEPTED, workItem );
   this.processEvent( event );
   if ( listener != null )
   {
      listener.workAccepted( event );
   }

   return workItem;
}

/* (non-Javadoc)
 * @see commonj.work.WorkManager#schedule(commonj.work.Work)
 */
public synchronized WorkItem schedule( Work work )
throws WorkException, 
       IllegalArgumentException
{
   return this.schedule( work, null );
}

/* (non-Javadoc)
 * @see commonj.work.WorkManager#waitForAll(java.util.Collection, long)
 */
public boolean waitForAll( Collection workItems,
                           long       timeout )
{
   Iterator workItemsIterator = workItems.iterator(  );
   Object   current;
   WorkItem workItem;
   int      status;

   if ( timeout == WorkManager.IMMEDIATE )
   {
      while ( workItemsIterator.hasNext(  ) )
      {
         current = workItemsIterator.next(  );
         if ( current instanceof WorkItem )
         {
            status = ( (WorkItem) current ).getStatus(  );
            if ( ( status != WorkEvent.WORK_COMPLETED ) && ( status != WorkEvent.WORK_REJECTED ) )
            {
               return false;
            }
         }
      }
   }
   else if ( timeout == WorkManager.INDEFINITE )
   {
      while ( workItemsIterator.hasNext(  ) )
      {
         current = workItemsIterator.next(  );
         if ( current instanceof WorkItem )
         {
            workItem = (WorkItem) current;
            synchronized ( workItem )
            {
               status = workItem.getStatus(  );
               while ( ( status != WorkEvent.WORK_COMPLETED ) && ( status != WorkEvent.WORK_REJECTED ) )
               {
                  try
                  {
                     workItem.wait(  );
                  }
                  catch ( InterruptedException e )
                  {
                     // not sure if this is the right thing to do
                     return false;
                  }

                  status = workItem.getStatus(  );
               }
            }
         }
      }
   }
   else
   {
      long absTimeout = System.currentTimeMillis(  ) + timeout;
      while ( workItemsIterator.hasNext(  ) )
      {
         current = workItemsIterator.next(  );
         if ( current instanceof WorkItem )
         {
            workItem = (WorkItem) current;
            synchronized ( workItem )
            {
               status = workItem.getStatus(  );
               while ( ( status != WorkEvent.WORK_COMPLETED ) && ( status != WorkEvent.WORK_REJECTED ) )
               {
                  if ( timeout > 0 )
                  {
                     try
                     {
                        workItem.wait( timeout );
                     }
                     catch ( InterruptedException e )
                     {
                        // not sure if this is the right thing to do
                        return false;
                     }

                     timeout = absTimeout - System.currentTimeMillis(  );
                  }
                  else
                  {
                     return false;
                  }

                  status = workItem.getStatus(  );
               }
            }
         }
      }
   }

   return true;
}

/* (non-Javadoc)
 * @see commonj.work.WorkManager#waitForAny(java.util.Collection, long)
 */
public Collection waitForAny( Collection workItems,
                              long       timeout )
{
   Iterator   workItemsIterator = workItems.iterator(  );
   Object     current;
   WorkItem   workItem;
   int        status;
   Collection result = new Vector(  );

   if ( timeout == WorkManager.IMMEDIATE )
   {
      while ( workItemsIterator.hasNext(  ) )
      {
         current = workItemsIterator.next(  );
         if ( current instanceof WorkItem )
         {
            workItem    = (WorkItem) current;
            status      = workItem.getStatus(  );
            if ( ( status == WorkEvent.WORK_COMPLETED ) || ( status == WorkEvent.WORK_REJECTED ) )
            {
               result.add( workItem );
            }
         }
      }
   }
   else if ( timeout == WorkManager.INDEFINITE )
   {
      if ( this.waitForAll( workItems, timeout ) )
      {
         return workItems;
      }
      else
      {
         return null;
      }
   }
   else
   {
      long absTimeout = System.currentTimeMillis(  ) + timeout;
      while ( workItemsIterator.hasNext(  ) )
      {
         current = workItemsIterator.next(  );
         if ( current instanceof WorkItem )
         {
            workItem = (WorkItem) current;
            synchronized ( workItem )
            {
               status = workItem.getStatus(  );
               while ( ( status != WorkEvent.WORK_COMPLETED )
                       && ( status != WorkEvent.WORK_REJECTED )
                       && ( timeout > 0 ) )
               {
                  try
                  {
                     workItem.wait( timeout );
                  }
                  catch ( InterruptedException e )
                  {
                     // not sure if this is the right thing to do
                     return null;
                  }

                  timeout    = absTimeout - System.currentTimeMillis(  );
                  status     = workItem.getStatus(  );
               }

               if ( ( status == WorkEvent.WORK_COMPLETED ) || ( status == WorkEvent.WORK_REJECTED ) )
               {
                  result.add( workItem );
               }
            }
         }
      }
   }

   return result;
}

/**
 * DOCUMENT_ME
 *
 * @param event DOCUMENT_ME
 * @throws WorkException 
 */
protected synchronized void processEvent( WorkEvent event ) throws WorkException
{
   Work currentWork = event.getWorkItem(  ).getResult();
   WorkItemImpl workItem = (WorkItemImpl) this.workItems.get( currentWork );
   if ( workItem != null )
   {
      int type = event.getType(  );
      workItem.setStatus( type );
      if ( ( type == WorkEvent.WORK_COMPLETED ) || ( type == WorkEvent.WORK_REJECTED ) )
      {
         synchronized ( workItem )
         {
        	System.out.println("Work "+currentWork.toString()+"Event notified:"+WorkEventHelper.decode(event));
            workItem.notifyAll(  );
         }

         this.workItems.remove( currentWork );
      }
   }
}

/**
 * DOCUMENT_ME
 *
 * @author $author$
 * @version $Revision: 1.6 $
 */
protected class WorkWrapper
   implements Runnable
{
   private Work         work;
   private WorkListener listener;

   /**
    * Creates a new {@link WorkWrapper} object.
    *
    * @param work     DOCUMENT_ME
    * @param listener DOCUMENT_ME
    */
   public WorkWrapper( Work         work,
                       WorkListener listener )
   {
      this.work        = work;
      this.listener    = listener;
   }

   /* (non-Javadoc)
    * @see java.lang.Runnable#run()
    */
   public void run(  )
   {
	   try{
      // TODO: fix this (what's wrong with it?)
      WorkItem  workItem = new WorkItemImpl( work );

      WorkEvent event = new WorkEventImpl( WorkEvent.WORK_STARTED, workItem );
      processEvent( event );
      if ( this.listener != null )
      {
         this.listener.workStarted( event );
      }

      this.work.run(  );

      event = new WorkEventImpl( WorkEvent.WORK_COMPLETED, workItem );
      processEvent( event );
      if ( this.listener != null )
      {
         this.listener.workStarted( event );
      }
	   }catch(Exception e){}
   }
}
}