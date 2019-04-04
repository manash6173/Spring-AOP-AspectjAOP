package com.manash.advice;

import org.springframework.aop.ThrowsAdvice;

public class ExceptionLoggerAdvice implements ThrowsAdvice {
	 public void afterThrowing(IllegalArgumentException iea) {
		 System.out.println("ExceptionLoggerAdvice.afterAdvice()");
	 }
}
