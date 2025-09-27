package com.geek.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	@Pointcut("execution(* com.geek.service.EmployeeServiceImpl.*(..))")
	private void commonLogs() {
		//dummy method ....
	}
	//@Before("execution(* com.geek.service.EmployeeServiceImpl.*(..))")
	@Before("commonLogs()")
	public void logs1() {
		System.out.println("before  logs ...");
	}
	//@After("execution(* com.geek.service.EmployeeServiceImpl.*(..))")
	@After("commonLogs()")
	public void logs2() {
		System.out.println("after  logs ...");
	}
}
