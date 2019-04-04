package com.manash.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;


import com.manash.config.AppConfig;
import com.manash.target.LoanApprover;

@SpringBootApplication
@ComponentScan(basePackages= {"com.manash.aspects","com.manash.target"})
@Import(value=AppConfig.class)
public class BeforeAdviceTest {

public static void main(String[] args) {
	ApplicationContext ctx=null;
	LoanApprover proxy=null;
	//create IOC Container
	ctx=SpringApplication.run(BeforeAdviceTest.class,args);
	//get proxy class Object
	proxy=ctx.getBean("pfb",LoanApprover.class);
	//invoke business method
	System.out.println(proxy.approveLoan("agri",40000, "Mr. Anand"));
	//close IOC Container
	((AbstractApplicationContext) ctx).close();
 }
	
}
