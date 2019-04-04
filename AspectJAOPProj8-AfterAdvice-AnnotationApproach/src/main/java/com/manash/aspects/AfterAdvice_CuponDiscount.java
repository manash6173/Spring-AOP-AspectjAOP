package com.manash.aspects;

import java.io.FileWriter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect()
@Component("copunAdvice")
public class AfterAdvice_CuponDiscount{

	@AfterReturning(value="execution(* com.manash.target.ShoppingStore.shop*(..) )" )
	public void cuponDiscount(JoinPoint jp,float billAmount) throws Throwable {
	  	float retVal=0.0f;
	  	String discountMsg=null;
	  	FileWriter writer=null;
	  	retVal=(Float)billAmount;
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
