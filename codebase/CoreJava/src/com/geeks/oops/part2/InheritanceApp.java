package com.geeks.oops.part2;

public class InheritanceApp {
	public static void main(String[] args) {
	  // new Product(); //ERROR !!!!
		Book book =new Book();
		book.setProductId(991);
		book.setProdName("Head first java");
		book.setPrice(999.99f);
		book.setAuthour("Kethy's Siera");
		book.setGenre("Computers");
		
		Apparal ap1=new Apparal();
		ap1.setProductId(992);
		ap1.setProdName("T Shirt");
		ap1.setPrice(1100.99f);
		ap1.setSize("M");
		ap1.setFabric("Cotton");
		
		Product myCart[]= {book,ap1};
		System.out.println("****ITEMS in the CART *****");
		for(Product p:myCart) {
		//	System.out.println(p.getProductId()+"  "+p.getProdName()+"  "+p.getPrice());
			//System.out.println("-------");
			p.print();//pure polymorphism. has many behaviours
			System.out.println("----------");
		}
		
		
	}

}
