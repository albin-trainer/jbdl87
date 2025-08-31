package com.geeks.streams;

import java.util.ArrayList;

public class Motication {
public static void main(String[] args) {
	Product p1=new Product(101,"T Shirt",999.99f,4.5f);
	Product p2=new Product(102,"Jeans",2999.99f,4.1f);
	Product p3=new Product(103,"TV",50000,4.9f);
	Product p4=new Product(104,"Laptop",70000.99f,4.2f);
	Product p5=new Product(105,"Pen",10,5f);
	ArrayList<Product> plist=new ArrayList<>();
	plist.add(p1);plist.add(p2);plist.add(p3);plist.add(p4);plist.add(p5);
	filterAndDisplay(plist);
}

static void filterAndDisplay(ArrayList<Product> plist) {
	for(Product p:plist) {
		if(p.getRatings()>=4.5) { //to filter by Price u hv to make a diff fn
			System.out.println(p.getProdName());
		}
	}
}
}
