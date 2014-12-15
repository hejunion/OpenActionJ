/**
 * #(@) ThreadPool.java Aug 16, 2006
 */
package com.ypg.merchant.services.concurrent.workmanager.ext;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Thread pool implementation to execute <code>Work</code> and 
 * <code>Timer</code>s.
 *
 */
public final class JDKThreadPool implements ThreadPool {

	private ThreadPoolExecutor pool;
	
	private int queueLength = 20;
	
	
	
	public JDKThreadPool() {
		this(5,20,100);
	}

	/**
	 * Creates a new instance of ThreadPool.
	 * 
	 * @param minThreads minimum number of threads
	 * @param maxThreads maximum number of threads
	 * @param queueLength length of the execution queue
	 */
	public JDKThreadPool(int minThreads, int maxThreads, int queueLength) {
		this.queueLength = queueLength;
		pool = new ThreadPoolExecutor(minThreads, maxThreads, 
				20, TimeUnit.SECONDS, 
				new ArrayBlockingQueue<Runnable>(queueLength),
				new ThreadPoolExecutor.CallerRunsPolicy());
	}

	/* (non-Javadoc)
	 * @see com.ypg.merchant.services.concurrent.workmanager.ext.ThreadPool#getMinThreads()
	 */
	public int getMinThreads() {
		return pool.getCorePoolSize();
	}

	/* (non-Javadoc)
	 * @see com.ypg.merchant.services.concurrent.workmanager.ext.ThreadPool#setMinThreads(int)
	 */
	
	public void setMinThreads(int coreThreads) {
		pool.setCorePoolSize(coreThreads);
	}

	/* (non-Javadoc)
	 * @see com.ypg.merchant.services.concurrent.workmanager.ext.ThreadPool#getMaxThreads()
	 */
	public int getMaxThreads() {
		return pool.getMaximumPoolSize();
	}

	/* (non-Javadoc)
	 * @see com.ypg.merchant.services.concurrent.workmanager.ext.ThreadPool#setMaxThreads(int)
	 */
	public void setMaxThreads(int maxThreads) {
		pool.setMaximumPoolSize(maxThreads);
	}

	/* (non-Javadoc)
	 * @see com.ypg.merchant.services.concurrent.workmanager.ext.ThreadPool#getQueueLength()
	 */
	public int getQueueLength() {
		return queueLength;
	}

	/* (non-Javadoc)
	 * @see com.ypg.merchant.services.concurrent.workmanager.ext.ThreadPool#setQueueLength(int)
	 */
	public void setQueueLength(int queueLength) {
		this.queueLength = queueLength;
	}


	/* (non-Javadoc)
	 * @see com.ypg.merchant.services.concurrent.workmanager.ext.ThreadPool#execute(java.lang.Runnable)
	 */
	public void execute(Runnable command) throws InterruptedException {
		pool.execute(command);
	}
	
	/* (non-Javadoc)
	 * @see com.ypg.merchant.services.concurrent.workmanager.ext.ThreadPool#shutdown()
	 */
	public void shutdown() {
		pool.shutdown();
	}

	/* (non-Javadoc)
	 * @see com.ypg.merchant.services.concurrent.workmanager.ext.ThreadPool#forceShutdown()
	 */
	public void forceShutdown() {
		pool.shutdownNow();
	}

}
