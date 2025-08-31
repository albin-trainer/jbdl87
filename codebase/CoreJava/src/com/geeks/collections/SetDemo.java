package com.geeks.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetDemo {
public static void main(String[] args) {
	//HashSet --No duplicates
	//       -- no gurarnty of order
	HashSet<String> set1=new HashSet<>();
	set1.add("Bangalore");
	set1.add("Chennai");
	set1.add("Mysore");
	set1.add("Mysore");
	set1.add("Delhi");
	set1.add("Mumbai");
	System.out.println(set1);
	System.out.println(set1.size());
	//TreeSet  -- No duplicates
	// -- sorted order in default
	TreeSet<String> set2=new TreeSet<>();
	set2.add("Chennai");
	set2.add("Bangalore");
	set2.add("Mysore");
	set2.add("Mysore");
	set2.add("Delhi");
	set2.add("Mumbai");
	System.out.println(set2);
	//LinkedHashSet -- no duplicates
	// arrange in insertion order
	LinkedHashSet<String> set3=new LinkedHashSet<>();
	set3.add("Chennai");
	set3.add("Bangalore");
	set3.add("Mysore");
	set3.add("Mysore");
	set3.add("Delhi");
	set3.add("Mumbai");
	System.out.println(set3);
	
}
}
