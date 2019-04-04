package com.manash.config;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.manash.advice.PerformanceMonitoring;
import com.manash.target.ArithematicsOperations;

@Configuration
@ComponentScan(basePackages= {"com.manash.target","com.manash.advice"})

public class AppConfig {
	@Autowired
	private PerformanceMonitoring advice=null;
	@Autowired
	private ArithematicsOperations target=null;
	
	@Bean("advisor")
	public NameMatchMethodPointcutAdvisor createAdvisor() {
		NameMatchMethodPointcutAdvisor advisor=null;
		//create advisor class object
		advisor=new NameMatchMethodPointcutAdvisor();
		//set advice class object
		advisor.addMethodName("add");
		advisor.setAdvice(advice);
		return advisor;
	}
	@Bean("pfb")
	public ProxyFactoryBean createProxy() {
		ProxyFactoryBean factory=null;
		//create proxy factory 
		factory=new ProxyFactoryBean();
		//add target class
		factory.setTarget(target);
		//add advisor class object
		factory.addAdvisor(createAdvisor());
		return factory;
	}
}
