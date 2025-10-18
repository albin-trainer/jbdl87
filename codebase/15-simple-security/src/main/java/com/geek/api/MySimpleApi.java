package com.geek.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MySimpleApi {
	@GetMapping("/home/admin")
public String hello() {
	return "Admin Page";
}
	
	@GetMapping("/home/user")
public String user() {
	return "User Page";
}
	
	@GetMapping
public String test() {
	return "Home Page";
}
}
