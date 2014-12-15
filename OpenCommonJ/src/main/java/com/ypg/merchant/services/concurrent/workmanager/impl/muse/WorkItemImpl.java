package com.ypg.merchant.services.concurrent.workmanager.impl.muse;

import commonj.work.Work;
import commonj.work.WorkException;
import commonj.work.WorkItem;
/**
 * An implementation of the CommonJ work item interface.
 */
public class WorkItemImpl
   implements WorkItem
{
   private int m_status = -1;

   private Work result;
   
   
   public WorkItemImpl(Work result) {
	super();
	this.result = result;
}

/**
    * DOCUMENT_ME
    *
    * @return DOCUMENT_ME
    *
    * @throws WorkException DOCUMENT_ME
    */
   public Work getResult(  )
   throws WorkException
   {
      return result; // TODO: implement
   }

   /* (non-Javadoc)
    * @see commonj.work.WorkItem#getStatus()
    */
   public synchronized int getStatus(  )
   {
      return m_status;
   }

   /**
    * DOCUMENT_ME
    *
    * @param o DOCUMENT_ME
    *
    * @return DOCUMENT_ME
    */
   public int compareTo( Object o )
   {
      return 0; // TODO: implement
   }

   /**
    * @param status the new status
    */
   protected synchronized void setStatus( int status )
   {
      // only update status if new status is later in the sequence
      if ( status > m_status )
      {
         m_status = status;
      }
   }
}