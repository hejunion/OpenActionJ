package com.ypg.merchant.services.concurrent.workmanager.ext;
import EDU.oswego.cs.dl.util.concurrent.PooledExecutor;

public class OswegoThreadPool implements ThreadPool {
	private PooledExecutor threadPool;
	private int queueLength = 20;
	
	public OswegoThreadPool() {
		this(5,20,100);
	}
	
	
	public OswegoThreadPool(int maxThreads) {
		this(5,maxThreads,100);
	}
	
	
	public OswegoThreadPool(int minThreads, int maxThreads, int queueLength) {
		this.queueLength = queueLength;
		this.threadPool = new PooledExecutor( maxThreads );
		this.threadPool.setMinimumPoolSize(minThreads);

	}
	

	public int getMinThreads() {
		// TODO Auto-generated method stub
		return this.threadPool.getMinimumPoolSize();
	}

	public void setMinThreads(int minThreads) {
		this.threadPool.setMinimumPoolSize(minThreads);

	}

	public int getMaxThreads() {
		// TODO Auto-generated method stub
		return this.threadPool.getMaximumPoolSize();
	}

	public void setMaxThreads(int maxThreads) {
		this.threadPool.setMaximumPoolSize(maxThreads);
	}

	public int getQueueLength() {
		// TODO Auto-generated method stub
		return this.queueLength;
	}

	public void setQueueLength(int queueLength) {
		this.queueLength= queueLength;

	}

	public void execute(Runnable command) throws InterruptedException {
		this.threadPool.execute(command);

	}

	public void shutdown() {
		this.threadPool.shutdownAfterProcessingCurrentlyQueuedTasks();

	}

	public void forceShutdown() {
		this.threadPool.shutdownNow();
	}

}
