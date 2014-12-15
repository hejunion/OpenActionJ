package com.ypg.merchant.services.actionframework.profile;

import java.lang.reflect.Method;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfilePostExecutionAdvisor extends AbstractPointcutAdvisor {


	private static final long serialVersionUID = -6091430442570440048L;

	private final StaticMethodMatcherPointcut pointcut = new
	            StaticMethodMatcherPointcut() {
	                @Override
	                public boolean matches(Method method, Class<?> targetClass) {
	                    return method.isAnnotationPresent(ProfileExecution.class);
	                }
	            };
	            
	@Autowired
	private ProfilePostExecutionAdvice profilePostExecutionAdvice;
	
	@Override
	public Pointcut getPointcut() {
		return pointcut;
	}

	@Override
	public Advice getAdvice() {
		return profilePostExecutionAdvice;
	}

}
