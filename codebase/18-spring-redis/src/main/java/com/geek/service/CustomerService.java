package com.geek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.geek.entity.Customer;
import com.geek.repo.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository custRepo;
	public Customer addNewCustomer(Customer c) {
		return custRepo.save(c);
	}
	//@Cacheable(value = "customer", key = "id")//in byte code it removes the param names
	@Cacheable(value = "customer", key = "#root.args[0]") //SPEL
	public Customer getById(int id) { 
		return custRepo.findById(id).orElseThrow(() -> new RuntimeException("cust not found"));
	}
}
