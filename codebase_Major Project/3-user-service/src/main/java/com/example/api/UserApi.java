package com.example.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.UserDto;
import com.example.entity.User;
import com.example.service.PaymentGateWay;
import com.example.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserApi {
	@Value("${msg}")
   private String msg;
	@Autowired
	private PaymentGateWay gateWay;
	@Autowired
	private UserService userService;
	Logger log=LoggerFactory.getLogger(UserApi.class);

	@GetMapping("/test")
	public String testConfig() {
		return msg;
	}
	@GetMapping("/pay")
	public String payment() {
		return gateWay.pay();
	}
	@PostMapping("/users")
	public User addNewUser(@Valid  @RequestBody   UserDto userDto) {
		log.info("Adding new user {} {}",userDto.getUserName(), userDto.getEmail());
		return userService.addNewService(userDto);
	}
	@GetMapping("/verifyuser/{id}")
	public boolean checkUserAvailability(@PathVariable("id")  int id) {
		log.info("searching the user {}",id);
		return userService.checkUserAvailability(id);
	}
	
}
