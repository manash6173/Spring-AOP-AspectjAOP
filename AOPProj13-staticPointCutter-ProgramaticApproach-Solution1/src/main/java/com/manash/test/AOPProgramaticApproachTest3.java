package com.manash.test;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

import com.manash.advice.PerformanceMonitoring;
import com.manash.target.ArithematicsOperations;

public class AOPProgramaticApproachTest3 {

	public static void main(String[] args) {
        ArithematicsOperations target=null,proxy=null;		
		PerformanceMonitoring advice=null;
        ProxyFactory factory=null;
		NameMatchMethodPointcutAdvisor advisor=null;
		
        //create Target class object
		target=new ArithematicsOperations();
		//create Advice class Object 
		advice=new PerformanceMonitoring();
		
		//create Advisor class Object
		advisor=new NameMatchMethodPointcutAdvisor(advice);
		//add target class object
		advisor.setMappedNames("add","mul");
		//create proxyFactory  class object 
		factory=new ProxyFactory();
		//set target class and advice class into proxyFactory
		factory.setTarget(target);
		factory.addAdvisor(advisor);
		//invoke proxy method
		proxy=(ArithematicsOperations) factory.getProxy();
		//invoke b.method on proxy class object
		System.out.println("Addition::"+proxy.add(10,20));
		System.out.println("---------------------------------");
		System.out.println("Substraction::"+proxy.sub(10, 20));
		System.out.println("---------------------------------");
		System.out.println("Multification::"+proxy.mul(10,20));
		System.out.println("---------------------------------");
		System.out.println("Division::"+proxy.div(10, 20));
	}

}
