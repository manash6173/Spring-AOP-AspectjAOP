package com.manash.pointcutter;

import java.lang.reflect.Method;


import org.springframework.aop.support.StaticMethodMatcherPointcut;

import com.manash.target.ArithematicsOperations;

public class ArithmeticsAddMethodPointCutter extends StaticMethodMatcherPointcut {

	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		if(targetClass.equals(ArithematicsOperations.class))
			if(method.getName().equalsIgnoreCase("mul"))
			return true;
		return false;	
	}
}
