package com.geeks.exceptions;

public class ThrowsEx1 {
public static void main(String[] args) {
	
}
void myMethod() {
	try {
		yourMethod();//this method must surround with try catch
	} catch (InterruptedException e) {
		e.printStackTrace();
	} 
}

void yourMethod() throws InterruptedException{
	
}

void myMethod1() {
	yourMethod1();
}
void yourMethod1() throws ArithmeticException{
	
}
}
