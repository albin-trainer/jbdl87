package com.geek.secure.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.geek.secure.model.User;
import com.geek.secure.repository.UserRepository;


@RestController
@CrossOrigin//to connect apps from other domains ..... Eg, React will run another server
public class MyController {
	@Autowired
	private UserRepository userRepo;
	@GetMapping("/")
	public String home() {
		return "<h1> Home Page</h1>";
	}
	@GetMapping("/user")
	public String user( Principal p ) {
		return "<h1> User Page "+p.getName()+"</h1>";
	}
	@GetMapping( value = "/admin",produces = {"application/json","application/xml"})
	public String admin() {
		return "<h1> Admin Page</h1>";
	}
	
	@PutMapping("/update")
	@PreAuthorize("hasAuthority('admin')") //role
	//@PreAuthorize("hasAnyRole('admin','user')")
	public String update(Principal p) {
		
		User user=userRepo.findByUsername(p.getName());

		return "<h1> Update Page "+p.getName()+ " and user id is "+ user.getId()+" </h1>";
	}
	@GetMapping("/user1")
	@PreAuthorize("hasAuthority('user')") //role
	public String user1(Principal p) {
		User user=userRepo.findByUsername(p.getName());
		return "<h1> User1ex Page "+p.getName()+" and user id is "+ user.getId()+" </h1>";
	}
	
}
