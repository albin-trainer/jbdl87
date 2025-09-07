package com.geeks.exceptions;

public class FinallyDemo2 {
public static void main(String[] args) {
	int r=testFinally();
	System.out.println(r);
}

static int testFinally() {
	try {
		System.out.println("in try");
		int arr[]= {1,2,3,4,5};
		System.out.println(arr[5]);
	
		return 1;
	}
	catch(ArrayIndexOutOfBoundsException e) {
		System.out.println("catch");
		return 2;
	}
	finally{
		System.out.println("Finally block....");
	}
}
}

