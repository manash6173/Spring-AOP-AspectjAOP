package com.manash.aspects;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(3)
@Aspect
@Component("pmAdvice")
public class PerformanceMonitoringAroundAdvice {
	@Around(value="execution(* com.manash.target.BankService.*(..))")
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
