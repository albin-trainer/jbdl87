package com.example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	@LoadBalanced
	//RestTemplateBuilder --> automatically configured to share the traceid to another microservice
	public RestTemplate getTemplate( RestTemplateBuilder templateBuilder ) {
		return templateBuilder.build();
	}

}
