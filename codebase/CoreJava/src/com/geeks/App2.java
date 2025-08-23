package com.geeks;
public class App2 {
public static void main(String[] args) {
	Product p1=new Product();
	p1.setProductId(9001);
	p1.setProdName("Phone");
	p1.setPrice(25000);
	
	Product p2=new Product();
	p2.setProductId(9002);
	p2.setProdName("Bag");
	p2.setPrice(1000);
	
	Product products[]= {p1,p2};
	Cart cart=new Cart();
	cart.setProducts(products);
	
	Customer c1=new Customer();
	c1.setCustId(101);
	c1.setCustName("Albin");
	c1.setAddress("Bangalore");
	c1.setMyCart(cart);
	//print all the data
	//print customer details
	//print the products in the cart
	
}
}
