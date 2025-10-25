package com.geek.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.geek.model.Product;

@Service
public class ProductService {
	static final String PRODUCT_KEY="products";
	@Autowired
	private RedisTemplate<String, Product> redisTemplate;
	public Product addProduct(Product p) {
		//store the product obj in the REDIS cache
		//key is the product id and value will be the product obj
		  redisTemplate.opsForHash().put(PRODUCT_KEY, String.valueOf(p.getProdId()), p);

	        // Optional: set TTL (Time To Live) for entire hash
	        redisTemplate.expire(PRODUCT_KEY, java.time.Duration.ofMinutes(30));
		return p;
	}
	public Product search(  int id) {
		Product p= (Product)
		redisTemplate.opsForHash().get(PRODUCT_KEY, String.valueOf(id));
		return p;
	}
}
