package com.manash.aspects;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class PerformingMonitoringAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		long start=0,end=0;
		Object retVal=null;
		// dvelope pre-method logic 
		start=System.currentTimeMillis();
		//invoke target class method by calling proceed() using invocation
		retVal=invocation.proceed();
		//develope post-method logic 
		end=System.currentTimeMillis();
		System.out.println(invocation.getMethod().getName()+" has taken"+(end-start)+"ms to complete the execution");
		return retVal;
	}
}
