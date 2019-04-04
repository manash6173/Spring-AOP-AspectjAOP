package com.manash.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.manash.target.BankService;


public class AspectsAroundAdviceTest {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		ApplicationContext ctx=null;
		BankService proxy=null;
		//create IOC Container
        ctx=new ClassPathXmlApplicationContext("com/manash/cfgs/applicationContext.xml");
        //get target class object from ProxyFactoryBean
        proxy=ctx.getBean("pfb",BankService.class);
        
        //invoke target class method
        System.out.println("Interest Amount is::"+proxy.findSimpleInterest(100000,12, 2));
       System.out.println("------------------------------------");
       System.out.println("Interest Amount is::"+proxy.findSimpleInterest(100000,12, 2));
       
       System.out.println("Interest Amount is::"+proxy.findSimpleInterest(100000,12, 2));
       System.out.println("------------------------------------");
       System.out.println("Interest Amount is::"+proxy.findSimpleInterest(100000,12, 2));
       


        //close IOC Container
        ((AbstractApplicationContext) ctx).close();
	}

}
