package com.manash.aspects;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Aspect
@Component("cacheAdvice")
public class CachingAroundAdvice {
	private Map<String, Object> cachemap=new HashMap<String,Object>();
	
	@Around(value="execution(float com.manash.target.BankService.cals*(..))")
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
