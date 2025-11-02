package com.example.proxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.model.Order;
	//Feigh without load balancing....
//@FeignClient(name = "prodserviceanyname",url = "http://localhost:8500")

//Feign with load balance
@FeignClient(name="product-service") //here url not req
public interface ProductProxy {
	@GetMapping("/products/{id}")
	public Order orderProduct(@PathVariable("id")  int id);
}
