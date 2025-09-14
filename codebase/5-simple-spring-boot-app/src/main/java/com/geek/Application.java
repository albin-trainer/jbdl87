package com.geek;

import java.util.Arrays;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication //@SpringBootConfiguration + @EnableAutoConfiguration+ 
//@ComponentScan
public class Application {
	public static void main(String[] args) {
		//initialize ApplicationContext
		//scans the class path initialize req components
		//finds Tomcate embededd server lib
		//starts the tomcat
		//returns ApplicationContext
		ApplicationContext ctx=
		SpringApplication.run(Application.class, args);
		String beans[]=  ctx.getBeanDefinitionNames();
		System.out.println("*****BEANS******");
		Stream.of(beans).forEach(beanName->System.out.println(beanName));
	}

}
