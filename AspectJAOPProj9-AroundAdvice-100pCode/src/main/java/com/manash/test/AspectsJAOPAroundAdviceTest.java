package com.manash.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.manash.cfgs.AppConfig;
import com.manash.target.BankService;

public class AspectsJAOPAroundAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService proxy=null;
		//create IOC container
		ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		//get proxy class object
		proxy=ctx.getBean("target",BankService.class);
		System.out.println(proxy.getClass());
		//invok target class method
		System.out.println("simple intrest amount is ::"+proxy.calsSimpleIntAmt(1000, 2, 12));
		System.out.println("---------------------");
		System.out.println("compoud intrest amount is:"+proxy.calsCompoundIntAmt(1000, 2, 12));
		
		System.out.println("simple intrest amount is ::"+proxy.calsSimpleIntAmt(1000, 2, 12));
		System.out.println("---------------------");
		System.out.println("compoud intrest amount is:"+proxy.calsCompoundIntAmt(1000, 2, 12));
		//close ioc container
		((AbstractApplicationContext) ctx).close();
	}
}
