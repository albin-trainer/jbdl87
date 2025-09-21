package com.geek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//initialize ApplicationContext
		//scans class path  and initialize the beans
		//since tomcat is in the classpath,
		// it automatically starts the tomcat server
		//and deploy this app in it
		//Auto configuration
		SpringApplication.run(Application.class, args);
	}

}
