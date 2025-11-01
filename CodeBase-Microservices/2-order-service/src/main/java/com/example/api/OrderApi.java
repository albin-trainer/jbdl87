package com.example.api;

import org.springframework.beans.factory.annotation.Autowired;
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
@Autowired
private RestTemplate template;
@PostMapping("/loadbalance/order/{id}/{q}")
public Order orderProductLoadBalancer(@PathVariable("id")  int id, @PathVariable("q") int q) { //best practice to make DTO
	//contact Eureka and find the services of product-service
	//pull all the services
	//load balancing here 
	//But Actually u nothing to do !!!!! Spring cloud take over everything....
	String url="http://product-service/products/"+id;
	Order order=   template.getForObject(url, Order.class);
	order.setTotalPrice(order.getPrice()*q);
	order.setQuantity(q);
	return order;
}
}
