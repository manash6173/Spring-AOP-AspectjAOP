package com.manash.advice;

public class ExceptionLoggerAdvice {
	 public void exceptionLogger(IllegalArgumentException iea) {
		 System.out.println("ExceptionLoggerAdvice.afterAdvice()");
	 }
}
