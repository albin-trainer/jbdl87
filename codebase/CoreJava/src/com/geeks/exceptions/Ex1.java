package com.geeks.exceptions;

public class Ex1 {
public static void main(String[] args) {
	System.out.println("Hello....");
	try {
		System.out.println("try start");
	int a=10;
	int b=5;
	int r=a/(b*2-a); 
	System.out.println("Result : "+r);
	System.out.println("End try");
	}
	catch(Throwable e) {
		System.out.println("catch");
	}
	System.out.println("End of main ...");
}
}
