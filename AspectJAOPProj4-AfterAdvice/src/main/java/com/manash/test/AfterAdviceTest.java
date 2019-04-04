package com.manash.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.manash.target.ShoppingStore;

public class AfterAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ShoppingStore proxy=null;
		//create IOC Container
		ctx=new ClassPathXmlApplicationContext("com/manash/cfgs/applicationContext.xml");
		//get proxy class object
         proxy=ctx.getBean("target",ShoppingStore.class);
         //invoke b.method
         System.out.println("Total Bill Amount::"+proxy.shoppingBillAmount(new String[] {"fruits","sweets","pooja samagri"},new float[] {10000.0f,20000.0f,30000.0f}));
	     //close IOC Container
         ((AbstractApplicationContext) ctx).close();
	}
}