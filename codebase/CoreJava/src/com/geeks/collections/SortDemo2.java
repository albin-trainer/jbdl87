package com.geeks.collections;
import java.util.ArrayList;
import java.util.Collections;
public class SortDemo2 {
public static void main(String[] args) {
	Product p1=new Product(101,"T Shirt",999.99f,4.5f);
	Product p2=new Product(102,"Jeans",2999.99f,4.1f);
	Product p3=new Product(103,"TV",50000,4.9f);
	Product p4=new Product(104,"Laptop",70000.99f,4.2f);
	Product p5=new Product(105,"Pen",10,5f);
	System.out.println(p1); //println invokes p1.toString()
	System.out.println(p1.toString());
	ArrayList<Product> plist=new ArrayList<>();
	plist.add(p1);plist.add(p2);plist.add(p3);plist.add(p4);plist.add(p5);
	System.out.println("---Before sorting--");
	System.out.println(plist);
	
	 //internally for comparing objs it invoke compareTo method
	Collections.sort(plist);
	System.out.println("---After sorting--");
	System.out.println(plist);
	//now u have to sort on ratings H to L
	Collections.sort(plist, new SortByRatings());
	System.out.println("---sorted by Ratings H to L--");
	System.out.println(plist);
}
}
