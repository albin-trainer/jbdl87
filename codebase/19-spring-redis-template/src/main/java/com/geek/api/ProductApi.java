package com.geek.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.geek.model.Product;

@RestController
public class ProductApi {
	@Autowired
	private ProductService service;
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product p) {
		return service.addProduct(p);
	}
	@GetMapping("/products/{id}")
	public Product search( @PathVariable("id") int id) {
		return service.search(id);
	}
}
