package com.mansh.aspects;

import java.io.FileWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import org.springframework.aop.MethodBeforeAdvice;

public class AuditingBoferAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		String msg=null;
		
		Writer writer=null;
		//generate loanId 
		
		//get target class details
		System.out.println("Target class Name:"+target.getClass().getName());
		System.out.println("Target class Method name:"+method.getName());
		System.out.println("Method Arguments:"+Arrays.toString(args));
		msg=" Loan come for approve --->>LoanDetails:: LoanType :: "+args[0]+"\n LoanAmount:: "+args[1]+"\n On Date::"+new Date()+" \n To::"+args[2];
		//create File to write data
		writer=new FileWriter("D:/auditing.txt",true);
		writer.write(msg);
		//close stream
		writer.flush();
		writer.close();
		

	}

}
