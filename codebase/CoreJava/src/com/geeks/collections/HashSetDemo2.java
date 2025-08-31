package com.geeks.collections;
import java.util.HashSet;
public class HashSetDemo2 {
public static void main(String[] args) {
	Emp e1=new Emp(101, "A");
	Emp e2=new Emp(101, "A"); //Duplicate data ...
	Emp e3=new Emp(102, "B");
	Emp e4=new Emp(103, "C");
	Emp e5=new Emp(104, "D");
	HashSet<Emp> set=new HashSet<>();
	set.add(e1);set.add(e2);set.add(e3);set.add(e4);set.add(e5);
	System.out.println(set.size()); //gives no of elements
	System.out.println(set);
//	System.out.println(e1.hashCode()); //generated based on the mem address
//	System.out.println(e2.hashCode());
//	System.out.println(e1.equals(e2));
}
}
class Emp{
	private int id;
	private String name;
	public Emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int hashCode() {
		System.out.println("**hashcode***");
		return id;
	}
	public boolean equals(Object obj) {
		System.out.println("**Equals***");
		Emp e=(Emp)obj;
		if(this.id==e.id && this.name.equals(e.name))
			return true;
		else
			return false;
	}
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + "]\n";
	}
}