package com.manash.aspects;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

import com.manash.manager.BankAuthenticateManager;

public class SecurityCheckingAdvice implements MethodBeforeAdvice {
	private BankAuthenticateManager authenticate;
	
	public SecurityCheckingAdvice(BankAuthenticateManager authenticate) {
		this.authenticate = authenticate;
	}


	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		//use authenticate obj
		if(!authenticate.validateUser())
			throw new IllegalArgumentException("InValid User");
	}
}
