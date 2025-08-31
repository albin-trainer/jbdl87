package com.geeks.collections;

import java.util.ArrayList;
import java.util.Collections;

public class SortDemo {
public static void main(String[] args) {
	ArrayList<String> list1=new ArrayList<>();
	list1.add("Bangalore");
	list1.add("Mysore");
	list1.add("Ahmedabad");
	list1.add("Chennai");
	list1.add("Cochin");
	System.out.println(list1);
	
	Collections.sort(list1);
	System.out.println("---after sorting ---");
	System.out.println(list1);

}
}
