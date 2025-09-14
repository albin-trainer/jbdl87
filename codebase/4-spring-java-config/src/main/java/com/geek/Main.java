package com.geek;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.geek.service.AccountService;
public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx=
			new AnnotationConfigApplicationContext(SpringConfig.class);
		System.out.println("--------");
		AccountService service=(AccountService) ctx.getBean("service");
		System.out.println(service.creditService(1000));
		
	}
}
