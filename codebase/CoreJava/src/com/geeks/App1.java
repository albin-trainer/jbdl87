package com.geeks;
public class App1 {
	public static void main(String[] args) {
		int x=100; //100 is a type of int
		 //here new Product() is the type of Product class
		Product p1= new Product(); //its REAL product
		//p1.productId=101;
		p1.setProductId(101);
		p1.setProdName("Phone");
		p1.setPrice(25000); //making a double and then convert into float 
		System.out.println("Product id  is "+  p1.getProductId());
		System.out.println("Product name is "+ p1.getProdName());
		System.out.println("Price is "+p1.getPrice());
		
		Product p2=new Product();
		p2.setProductId(102);
		p2.setProdName("Laptop");
		p2.setPrice(60000);
		System.out.println("Product id  is "+  p2.getProductId());
		System.out.println("Product name is "+ p2.getProdName());
		System.out.println("Price is "+p2.getPrice());
		
		p1.discount(1000);
		System.out.println("updated price "+p1.getPrice());
	}
}
