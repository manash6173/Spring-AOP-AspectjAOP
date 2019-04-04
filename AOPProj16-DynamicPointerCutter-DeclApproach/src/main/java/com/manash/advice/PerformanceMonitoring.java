package com.manash.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class PerformanceMonitoring implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		long start=0,end=0;
		Object retVal=null;
		//get time in milisecond
		start=System.currentTimeMillis();
		//invoke target class method
		retVal=invocation.proceed();
		end=System.currentTimeMillis();
		System.out.println(invocation.getMethod().getName()+" Method has taken "+(end-start)+"ms time to complete the execution");
		return retVal;
		
	}
}
