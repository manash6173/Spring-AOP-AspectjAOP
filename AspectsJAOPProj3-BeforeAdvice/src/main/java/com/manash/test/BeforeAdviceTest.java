package com.manash.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.manash.target.LoanApprover;

public class BeforeAdviceTest {
 
	public static void main(String[] args) {
		ApplicationContext ctx=null;
		LoanApprover proxy=null;
		//create IOC Container
		ctx=new ClassPathXmlApplicationContext("com/manash/cfgs/applicationContext.xml");
		//get target class objects
		proxy=ctx.getBean("target",LoanApprover.class);
		//invoke target class
		System.out.println(proxy.approveLoan("agri",12000, "Ramesh"));
		//close IOC Container
		((AbstractApplicationContext) ctx).close();
	}
}
