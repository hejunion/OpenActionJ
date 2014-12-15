package com.ypg.merchant.services.concurrent.workmanager.impl.muse;

import commonj.work.WorkEvent;
import commonj.work.WorkException;
import commonj.work.WorkItem;

public class WorkEventImpl
implements WorkEvent
{
private WorkException exception;
private int           type;
private WorkItem      workItem;

/**
 * @param type
 * @param work
 */
public WorkEventImpl( int      type,
                      WorkItem work )
{
   this( null, type, work );
}

/**
 * @param exception
 * @param type
 * @param work
 */
public WorkEventImpl( WorkException exception,
                      int           type,
                      WorkItem      work )
{
   this.exception    = exception;
   this.type         = type;
   this.workItem     = work;
}

/* (non-Javadoc)
 * @see commonj.workItem.WorkEvent#getException()
 */
public WorkException getException(  )
{
   return this.exception;
}

/* (non-Javadoc)
 * @see commonj.workItem.WorkEvent#getType()
 */
public int getType(  )
{
   return this.type;
}

/* (non-Javadoc)
 * @see commonj.workItem.WorkEvent#getWork()
 */
public WorkItem getWorkItem(  )
{
   return this.workItem;
}
}