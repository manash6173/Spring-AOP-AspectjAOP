package com.manash.aspects;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CacheAdvice implements MethodInterceptor{
	Map<String, Object> cache=new HashMap<String,Object>();
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		String key=null;
		Object retVal=null;
				
		key=invocation.getMethod().getName()+Arrays.toString(invocation.getArguments());
		if(!cache.containsKey(key)) {
			System.out.println(cache.containsKey(key));
			retVal=invocation.proceed();
			cache.put(key,retVal);
			System.out.println("From Target class");
			return retVal;
		}
			System.out.println("From Cache");
			return cache.get(key);
	}
	

}
