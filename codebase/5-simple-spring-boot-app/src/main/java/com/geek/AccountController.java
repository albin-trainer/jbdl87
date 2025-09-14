package com.geek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geek.service.AccountService;

@RestController
public class AccountController {
	@Autowired
	private AccountService accService;
	
	@GetMapping("/test")
	public String test() {
		return accService.creditService(100000);
	}
}
