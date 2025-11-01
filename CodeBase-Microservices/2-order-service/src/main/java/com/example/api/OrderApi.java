package com.example.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.model.Order;

@RestController
public class OrderApi {
@PostMapping("/order/{id}/{q}")
	public Order orderProduct(@PathVariable("id")  int id, @PathVariable("q") int q) { //best practice to make DTO
		//make a rest call over the network to produc-service
	String url="http://localhost:8500/products/"+id;
	//REST client (like post man)
	RestTemplate template= new RestTemplate();
	Order order=   template.getForObject(url, Order.class);
	order.setTotalPrice(order.getPrice()*q);
	order.setQuantity(q);
	return order;
	}
}
