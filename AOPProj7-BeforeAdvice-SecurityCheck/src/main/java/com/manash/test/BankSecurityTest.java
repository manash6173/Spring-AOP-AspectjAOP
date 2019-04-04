package com.manash.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.manash.manager.BankAuthenticateManager;
import com.manash.service.BankService;
import com.manash.service.BankServiceImpl;

public class BankSecurityTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankAuthenticateManager auth=null;
		BankService proxy=null;
		//create IOC container
         ctx=new ClassPathXmlApplicationContext("com/manash/cfgs/applicationContext.xml");
         //get manager class object
         auth=ctx.getBean("bankAuth",BankAuthenticateManager.class);
         //get proxy class object
         proxy=ctx.getBean("bankService",BankServiceImpl.class);
         //invoke signIN Method
         auth.signIN("raja", "rani");
         //invoke b.method
         System.out.println(proxy.withdraw(1001, 100));
         
         //call signOut method
         auth.signOut();
         //close container
         ((AbstractApplicationContext) ctx).close();
	}

}
