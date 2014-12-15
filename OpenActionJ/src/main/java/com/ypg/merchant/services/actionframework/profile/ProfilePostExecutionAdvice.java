package com.ypg.merchant.services.actionframework.profile;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import com.ypg.merchant.services.action.Action;
import com.ypg.merchant.services.action.ActionCallBack;


@Component
public class ProfilePostExecutionAdvice implements MethodBeforeAdvice, AfterReturningAdvice, ActionCallBack {

	
	
	@Override
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
			//
	}

	@Override
	public void afterReturning(Object resultvalue, Method method, Object[] args,
			Object target) throws Throwable {
		if (args.length>=1){
			
			Object valueParamObj0 = args[0];
			if (Action.class.isAssignableFrom(valueParamObj0.getClass())){
				Action actionObj = (Action)valueParamObj0;
				actionObj.actionPerformed(this);
			}
		}

	}

	@Override
	public void beforeExecution(Action actioin) {
	
	}

	@Override
	public void afterExection(Action action) {
		System.out.println("Executed..."+action.getName());
		
	}

}
