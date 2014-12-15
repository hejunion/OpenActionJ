package com.ypg.merchant.services.actionframework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ActionMethodInvoker {

	private Object hostObj;
	private Method method;
	
	public ActionMethodInvoker(Object hostObj, Method method) {
		super();
		this.hostObj = hostObj;
		this.method = method;
	}

	
	public Object getHostObj() {
		return hostObj;
	}


	public Method getMethod() {
		return method;
	}


	public void invoke(Object... parameters) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{

			method.invoke(hostObj, parameters);

	}
	
}
