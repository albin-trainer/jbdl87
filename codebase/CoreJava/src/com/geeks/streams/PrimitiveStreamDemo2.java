package com.geeks.streams;

import java.util.ArrayList;

public class PrimitiveStreamDemo2 {
public static void main(String[] args) {
	Product p1=new Product(101,"T Shirt",999.99f,4.5f);
	Product p2=new Product(102,"Jeans",2999.99f,4.1f);
	Product p3=new Product(103,"TV",50000,4.9f);
	Product p4=new Product(104,"Laptop",70000.99f,4.2f);
	Product p5=new Product(105,"Pen",10,5f);
	ArrayList<Product> plist=new ArrayList<>();
	plist.add(p1);plist.add(p2);plist.add(p3);plist.add(p4);plist.add(p5);
	//find the total amt 
	double totalAmt=   plist.stream().mapToDouble(p->p.getPrice()).sum();
	System.out.println("Total amt is "+totalAmt);
	
	//find the average rating of the products....
	double avgRating=   plist.stream().mapToDouble(p->p.getRatings()).average().getAsDouble();
	System.out.println("Average rating : "+avgRating);
}
}
