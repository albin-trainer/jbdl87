package com.geeks.lambda;

public class LambdaEx2 {

	public static void main(String[] args) {
		//create a lambda expr and pass it to eval fn
		//ur TASK .....
		
		eval((a, b)->a+b, 1,1);
		Calculator c =(a, b)->a+b;
		eval(c, 9, 90);
	}
	
	static void eval(Calculator c, float x, float b) {
		System.out.println(c.eval(x, b));
	}
}
@FunctionalInterface //it makes sure it allows only one abstract method
interface Calculator{
	float eval(float a, float b);
	//void f1();
}

