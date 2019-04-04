package com.manash.advice;

import java.io.FileWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.springframework.aop.MethodBeforeAdvice;

public class AuditingBoferAdvice {

	/*public void loanApprover(JoinPoint jp) throws Throwable {
		String msg=null;
		Object[] args=jp.getArgs();
		Writer writer=null;
		//generate loanId 
		
		//get target class details
		System.out.println("Target class Name:"+jp.getClass().getName());
		System.out.println("Method Arguments:"+Arrays.toString(args));
		System.out.println("Method Name::"+jp.getSignature());
		msg=" Loan come for approve --->>LoanDetails:: LoanType :: "+args[0]+"\n LoanAmount:: "+args[1]+"\n On Date::"+new Date()+" \n To::"+args[2];
		//create File to write data
		writer=new FileWriter("D:/auditing.txt",true);
		writer.write(msg);
		//close stream
		writer.flush();
		writer.close();
	}*/
	/*public void loanApprover(JoinPoint jp,String type,int amt,String aprv) throws Throwable {
		String msg=null;
		Object[] args=jp.getArgs();
		Writer writer=null;
		//get target class arguments
		System.out.println(type+"......"+amt+"..........."+aprv);
		msg=" Loan come for approve --->>LoanDetails:: LoanType :: "+args[0]+"\n LoanAmount:: "+args[1]+"\n On Date::"+new Date()+" \n To::"+args[2];
		//create File to write data
		writer=new FileWriter("D:/auditing.txt",true);
		writer.write(msg);
		//close stream
		writer.flush();
		writer.close();
	}*/
	public void loanApprover(String type,int amt,String aprv) throws Throwable {
		String msg=null;
		Writer writer=null;
		//get target class arguments
		System.out.println(type+"......"+amt+"..........."+aprv);
		msg=" Loan come for approve --->>LoanDetails:: LoanType :: "+type+"\n LoanAmount:: "+amt+"\n On Date::"+new Date()+" \n To::"+aprv;
		//create File to write data
		writer=new FileWriter("D:/auditing.txt",true);
		writer.write(msg);
		//close stream
		writer.flush();
		writer.close();
	}
}
