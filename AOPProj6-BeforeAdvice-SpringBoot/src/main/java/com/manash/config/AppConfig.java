package com.manash.config;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.manash.target.LoanApprover;

@Configuration
@ComponentScan(basePackages= {"com.manash.target","com.manash.aspects"})
public class AppConfig {
	@Autowired
	private LoanApprover target;
	
	@Bean("pfb")
	public ProxyFactoryBean createFactoryBean() {
		ProxyFactoryBean pfb=null;
		//create factory Bean
		pfb=new ProxyFactoryBean();
		//inject target class object
		pfb.setTarget(target);
		pfb.setInterceptorNames("auditAdvice");
		return pfb;
	}
	

}
