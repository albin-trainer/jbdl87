package com.geeks.collections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Consumer;
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
	Comparator<Product>comparator=(Product pr1, Product pr2) ->{
		return pr1.getPrice()<pr2.getPrice()?-1:1;
	};
	Collections.sort(plist,comparator);
	//display it ...
	Consumer<Product> c=(p)->System.out.println(p);
	System.out.println("-----------");
	plist.forEach(c);
	Collections.sort(plist, (pr1,pr2)->pr1.getPrice()<pr2.getPrice()?-1:1);
	
}
}
