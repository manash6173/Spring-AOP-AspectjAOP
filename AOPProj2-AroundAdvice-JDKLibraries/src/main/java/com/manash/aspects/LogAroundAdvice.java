package com.manash.aspects;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class LogAroundAdvice implements MethodInterceptor{
	private static Logger logger=Logger.getLogger(LogAroundAdvice.class);
	public LogAroundAdvice() {
	//	PropertyConfigurator.configure();
	}

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object retVal=null;
		Object args[]=null;
		
		System.out.println("Entering into "+invocation.getMethod().getName()+" With Arguments"+Arrays.toString(invocation.getArguments()));
		args=invocation.getArguments();
		if((Float)args[0]<50000.0)
			 args[2]=1.5f;
		retVal=invocation.proceed();
		System.out.println("Exit from "+invocation.getMethod().getName());
		if((Float)args[0]<20000)
			return retVal;
		else
			return (Float)retVal+(Float)retVal*0.1f;
			
		
		
	}
	

}
