package com.geeks.collections;

import java.util.Vector;

public class VectorEx1 {
public static void main(String[] args) {
	//creates a array of size 10
	//its a dynamic array it keeps grow .....
	/*Vector v1= new Vector();
	v1.add(100); //Auto boxing
	v1.add("Bangalore");
	v1.add(true);
	
	//Auto unboxing 
	int x=(int)v1.get(0); //i hv to do typecasting
	String c=(String)v1.get(2); //typecast exception @runtime
	boolean b=(Boolean)v1.get(2);
	System.out.println(x);
	System.out.println(c);
	System.out.println(b);
	*/
	Integer x=100; //Auto boxing
	int y=x; //Auto unboxing ..
	//Generics -Parameterized type
	//         - avoids typecast exception 
	//ur work to create OWN Generic class ....
	Vector<String> v1=new Vector<>();
	v1.add("Bangalore");
	v1.add("Mysore");
	v1.add("Chennai");
	String s=v1.get(0); //Type casting not req while reading
	System.out.println(s);
	//default capacity  is 10 
	//
	Vector<Integer> v2=new Vector<>();
	v2.add(100);
	v2.add(99);
	System.out.println(v2.capacity());
	
	//internally vector creates a array of size 3
	Vector<String> v3=new Vector<>(3);
	v3.add("Bangalore");
	v3.add("Mysore");
	System.out.println(v3.capacity());
	v3.add("Mumbai");
	
	//creates a another array of double the size
	//and copies the data from old to new array
	v3.add("Chennai");
	System.out.println(v3);
	System.out.println(v3.capacity());
	
	
}
}
