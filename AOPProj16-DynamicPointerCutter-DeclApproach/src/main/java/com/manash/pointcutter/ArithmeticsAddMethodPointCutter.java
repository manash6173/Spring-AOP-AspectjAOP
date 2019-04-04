package com.manash.pointcutter;

import java.lang.reflect.Method;

import org.springframework.aop.support.DynamicMethodMatcherPointcut;


import com.manash.target.ArithematicsOperations;

public class ArithmeticsAddMethodPointCutter extends DynamicMethodMatcherPointcut {
	@Override
	public boolean matches(Method method, Class<?> targetClass, Object... args) {
		if(targetClass==ArithematicsOperations.class)
			if(method.getName().equalsIgnoreCase("add") || method.getName().equalsIgnoreCase("mul"))
				if(((Float)args[0])>=1000 && ((Float)args[1])>=1000)
					return true;
		return false;
	}
}
