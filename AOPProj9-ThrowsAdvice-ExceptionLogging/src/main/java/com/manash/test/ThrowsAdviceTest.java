package com.manash.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.manash.target.ShoppingStore;

public class ThrowsAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ShoppingStore proxy=null;
		//create IOC Container
		ctx=new ClassPathXmlApplicationContext("com/manash/cfgs/applicationContext.xml");
		proxy=ctx.getBean("pfb",ShoppingStore.class);
		//invoke target class object
		try {
			System.out.println("Total Bill Amount::"+proxy.calculatetBillAmt(10000, 10));
		}
		catch(IllegalArgumentException iae) {
			iae.printStackTrace();
		}
		//close ioc container
		((AbstractApplicationContext) ctx).close();
	}
}
