package com.geeks.streams;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
	
	//sort the list based on price L to H
	//find the highest rated    product
	//find the cheapest product
	List<Product> sortedProducts=
	plist.stream().sorted( (pr1,pr2)->pr1.getPrice()<pr2.getPrice()?-1:1 ).toList();
	System.out.println("-----------------");
	sortedProducts.forEach(p->System.out.println(p));
	
	Optional<Product>optionalProduct=
	plist.stream().max((pr1,pr2)->pr1.getRatings()<pr2.getRatings()?-1:1 );
	if(optionalProduct.isPresent()) {
		Product highestRatedProduct=optionalProduct.get();
		System.out.println("Highest rated product is "+highestRatedProduct.getProdName());
	}
	
	
	
}
}
