package com.geek.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.geek.entity.Customer;
import com.geek.service.CustomerService;

@RestController
public class CustomerApi {
	@Autowired
	private CustomerService service;
	@PostMapping("/customers")
	public Customer addNewCustomer(@RequestBody Customer c) {
		return service.addNewCustomer(c);
	}
	@GetMapping("/customers/{id}")
	public Customer getById(@PathVariable("id")  int id) {
		return service.getById(id);
	}
}
