package com.geeks.collections;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListEx1 {
public static void main(String[] args) {
	ArrayList<String> list1=new ArrayList<>();
	
	long t1=System.currentTimeMillis();//returns cur time in millies
	for(int i=1;i<=1000000;i++)
		list1.add("Apple");
	long t2=System.currentTimeMillis();
	System.out.println("Time took for array "+(t2-t1));
	
	
	LinkedList<String> list2=new LinkedList<>();
	 t1=System.currentTimeMillis();//returns cur time in millies
	for(int i=1;i<=1000000;i++)
		list2.add("Apple");
	 t2=System.currentTimeMillis();
	System.out.println("Time took for Linked List "+(t2-t1));

}
}
