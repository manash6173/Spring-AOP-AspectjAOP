package com.manash.aspects;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;

public class PerformanceMonitoringAroundAdvice {
	public Object monitor(ProceedingJoinPoint pjp) throws Throwable {
		long start=0,end=0;
		Object retVal=null;
		start=System.currentTimeMillis();
		retVal=pjp.proceed();
		end=System.currentTimeMillis();
		System.out.println(pjp.getSignature()+" has taken "+(end-start)+"ms time to execute with params"+Arrays.toString(pjp.getArgs()));
	return retVal;
	}

}
