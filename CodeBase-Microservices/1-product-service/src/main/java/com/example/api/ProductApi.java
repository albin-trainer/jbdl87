package com.example.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;
import com.example.service.ProductService;

@RestController
public class ProductApi {
	@Autowired
	private ProductService service;
	@GetMapping("/products/{id}")
	public Product searchById( @PathVariable("id") int id) {
		return service.searchById(id);
	}
}
