package com.manash.aspects;

import org.aspectj.lang.ProceedingJoinPoint;

public class RebateAdvice {
	
	public Object rebate(ProceedingJoinPoint pjp)throws Throwable{
		Object args[]=null;
		Object retVal=null;
		//get all arguments
		args=pjp.getArgs();
		if((Float)args[0]<=50000) {
		    args[1]=(Float)args[1]-0.5f;
		   retVal=pjp.proceed(args);
		}
		else {
			retVal=pjp.proceed();
		}
		//add GST
		retVal=(Float)retVal+((Float)retVal*0.05f);
		
		return retVal;
	}

}