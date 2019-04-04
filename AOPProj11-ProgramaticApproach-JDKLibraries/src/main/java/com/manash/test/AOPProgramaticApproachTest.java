package com.manash.test;

import org.springframework.aop.framework.ProxyFactory;

import com.manash.advice.CacheAdvice;
import com.manash.advice.PerformanceMonitoring;
import com.manash.target.ArithematicsOperations;
import com.manash.target.ArithematicsOperationsImpl;

public class AOPProgramaticApproachTest {

	public static void main(String[] args) {
        ArithematicsOperations target=null,proxy=null;		
		PerformanceMonitoring advice1=null;
		CacheAdvice advice2=null;
        ProxyFactory factory=null;
		//create Target class object
		target=new ArithematicsOperationsImpl();
		//create Advice class Object
		advice1=new PerformanceMonitoring();
		advice2=new CacheAdvice();
		//create proxyFactory  class object 
		factory=new ProxyFactory();
		//set target class and advice class into proxyFactory
		factory.setTarget(target);
		factory.addAdvice(advice1);
		factory.addAdvice(advice2);
		factory.addInterface(ArithematicsOperations.class);
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
		System.out.println("---------------------------------");
		System.out.println("Division::"+proxy.div(10, 20));
	}

}
