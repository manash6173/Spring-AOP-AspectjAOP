package com.manash.aspects;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;

public class CachingAroundAdvice {
	private Map<String, Object> cachemap=new HashMap<String,Object>();
	public Object caching(ProceedingJoinPoint pjp) throws Throwable {
		String key=null;
		Object retVal=null;
		key=pjp.getSignature()+""+Arrays.toString(pjp.getArgs());
		if(!cachemap.containsKey(key)) {
			retVal=pjp.proceed();
			cachemap.put(key, retVal);
			System.out.println("from Advice Class Method");
			return retVal;
		}
		else {
			System.out.println("form cache");
			return cachemap.get(key);
		}
	  	
	}

}
