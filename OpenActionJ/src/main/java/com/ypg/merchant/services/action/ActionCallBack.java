package com.ypg.merchant.services.action;

public interface ActionCallBack {

	public void beforeExecution(Action actioin);
	public void afterExection(Action action);
}
