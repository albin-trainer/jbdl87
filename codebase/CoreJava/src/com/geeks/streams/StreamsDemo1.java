package com.geeks.streams;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;
public class StreamsDemo1 {
public static void main(String[] args) {
	Product p1=new Product(101,"T Shirt",999.99f,4.5f);
	Product p2=new Product(102,"Jeans",2999.99f,4.1f);
	Product p3=new Product(103,"TV",50000,4.9f);
	Product p4=new Product(104,"Laptop",70000.99f,4.2f);
	Product p5=new Product(105,"Pen",10,5f);
	ArrayList<Product> plist=new ArrayList<>();
	plist.add(p1);plist.add(p2);plist.add(p3);plist.add(p4);plist.add(p5);
	
  // Stream<Product> st1=	plist.stream();
   //st1.filter(null);
	Predicate<Product> predicate=p->p.getRatings()>=4.5;
	Consumer<Product>consumer=p->System.out.println(p.getProdName());
	plist.stream().filter(predicate).forEach(consumer);
}
}
