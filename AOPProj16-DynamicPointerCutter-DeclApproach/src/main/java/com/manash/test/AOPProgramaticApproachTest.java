package com.manash.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.manash.target.ArithematicsOperations;

public class AOPProgramaticApproachTest {

	public static void main(String[] args) {
		 ApplicationContext ctx=null;
        ArithematicsOperations proxy=null;		
       //create IOC container 
        ctx=new ClassPathXmlApplicationContext("com/manash/cfgs/applicationContext.xml"); 
        
		proxy=ctx.getBean("pfb",ArithematicsOperations.class);
		//invoke b.method on proxy class object
		System.out.println("Addition::"+proxy.add(1011,2011));
		System.out.println("---------------------------------");
		System.out.println("Substraction::"+proxy.sub(10, 20));
		System.out.println("---------------------------------");
		System.out.println("Multification::"+proxy.mul(1001,2001));
		System.out.println("---------------------------------");
		System.out.println("Division::"+proxy.div(10, 20));
		//close IOC container
		((AbstractApplicationContext) ctx).close();
	}

}
