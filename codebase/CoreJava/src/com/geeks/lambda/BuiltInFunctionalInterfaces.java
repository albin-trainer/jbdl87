package com.geeks.lambda;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class BuiltInFunctionalInterfaces {
public static void main(String[] args) {
	ArrayList<Integer> list=new ArrayList<>();
	list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);list.add(6);
	
	//remove all even nos
	Predicate<Integer> predicate= (n)->n%2==0;
	list.removeIf(predicate);
	System.out.println(list);
	
	Consumer<Integer> consumer=(n)->System.out.println("*****"+n+"******");
	list.forEach(consumer);
	
	
	
}
}
