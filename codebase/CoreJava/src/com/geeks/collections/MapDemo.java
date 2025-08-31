package com.geeks.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class MapDemo {
public static void main(String[] args) {
	HashMap<String,String> map1=new HashMap<>();
	map1.put("E-001", "Arjun");
	map1.put("E-002", "Balaram");
	map1.put("E-003", "Brinda");
	map1.put("E-004", "Karan");
	map1.put("E-005", "Lakshman");
	map1.put("E-003", "Brinda Simon"); //overwrites
	System.out.println(map1);
	String ename=map1.get("E-001");
	System.out.println(ename);
	//CANNNOT ITERATE MAP DIRECTLY ...
	Set<String>empIds=   map1.keySet();//returns view of empid
	for(String id:empIds) {
		System.out.println(id);
	}
	System.out.println("--------------");
	Collection<String>empsNames=  map1.values();//returns values view
	for(String n:empsNames) {
		System.out.println(n);
	}
	
	//Entry --> represent a pair of key-value
	Set<Entry<String, String>> records=map1.entrySet();
	System.out.println("***************");
	for(Entry<String, String> row:records) {
		String id=row.getKey();
		String name=row.getValue();
		System.out.println(id+"    "+name);
	}
}
}
