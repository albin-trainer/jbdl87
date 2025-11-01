package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.model.Product;

@Service
public class ProductService {
	List<Product> products= new ArrayList<>();
	@Autowired
	private Environment env;
	
	public void loadProducts() {
		String port=env.getProperty("local.server.port"); //to get the port no of current instance 
		products.add(new Product(101, "T shirt", 1000, port));
		products.add(new Product(102, "Jeans", 2000, port));

		products.add(new Product(103, "Shoes", 3000, port));
		products.add(new Product(104, "Mobile", 20000, port));

	}
	public Product searchById(  int id) {
		loadProducts();
		return products.stream().filter(p->p.getProductId()==id).findFirst().get();
	}
}
