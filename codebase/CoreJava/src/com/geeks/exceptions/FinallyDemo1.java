package com.geeks.exceptions;

public class FinallyDemo1 {
public static void main(String[] args) {
	try {
		System.out.println("opening a resource");
		int a=100;
		if(a>=100) {
			System.out.println("Good evening");
			return;
		}
	}
	finally {
		System.out.println("I m finally i m closing the res...");
	}
	System.out.println("End of main ....");
}
}
