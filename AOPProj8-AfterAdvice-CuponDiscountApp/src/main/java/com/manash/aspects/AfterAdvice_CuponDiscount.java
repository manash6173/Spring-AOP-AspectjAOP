package com.manash.aspects;

import java.io.FileWriter;
import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class AfterAdvice_CuponDiscount implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
	  	float retVal=0.0f;
	  	String discountMsg=null;
	  	FileWriter writer=null;
	  	retVal=(Float)returnValue;
	  	if(retVal<30000)
	  		discountMsg="Available discount 10% on next purchese";
	  	else if(retVal<5000)
	  		discountMsg="Available discount 20% on next purchese";
	  	else if(retVal<10000)
	  		discountMsg="Available discount 30% on next purchese";
	  	else
	  		discountMsg="Available discount 40% on next purchese";
	  	writer=new FileWriter("D:\\discountCupon.txt");
	  	writer.write(discountMsg);
	  	writer.flush();
	  	//close file Stream
	  	writer.close();
	}
}
