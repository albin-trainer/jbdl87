package com.geek.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		//initialize spring container .....
		ApplicationContext ctx= 
		new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("IOC container initialized ....");
		GreetingBean g=(GreetingBean) ctx.getBean("greet");
		System.out.println(g.sayHello("Albin"));
		//Assume other client
		GreetingBean g2=(GreetingBean) ctx.getBean("greet");
		System.out.println(g2.sayHello("Alex"));
		System.out.println(g==g2);
	}
}
