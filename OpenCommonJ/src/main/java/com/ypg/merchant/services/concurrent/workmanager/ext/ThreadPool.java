package com.ypg.merchant.services.concurrent.workmanager.ext;

public interface ThreadPool {

	/**
	 * @return the coreThreads
	 */
	public int getMinThreads();

	/**
	 * @param coreThreads the coreThreads to set
	 */
	public void setMinThreads(int coreThreads);

	/**
	 * @return the maxThreads
	 */
	public int getMaxThreads();

	/**
	 * @param maxThreads the maxThreads to set
	 */
	public void setMaxThreads(int maxThreads);

	/**
	 * @return the queueLength
	 */
	public int getQueueLength();

	/**
	 * @param queueLength the queueLength to set
	 */
	public void setQueueLength(int queueLength);

	/**
	 * Arrange for the given command to be executed by a thread in this
	 * pool. The method normally returns when the command has been
	 * handed off for (possibly later) execution.
	 * 
	 * @param command command to execute
	 * @throws InterruptedException if execution fails
	 */
	public void execute(Runnable command) throws InterruptedException;

	/**
	 * Shutdown the pool after processing the currently queue tasks.
	 */
	public void shutdown();

	/**
	 * Force shutdown the pool immediately.
	 */
	public void forceShutdown();

}