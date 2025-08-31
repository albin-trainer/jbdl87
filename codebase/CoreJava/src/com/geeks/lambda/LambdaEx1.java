package com.geeks.lambda;
public class LambdaEx1 {
public static void main(String[] args) {
	postInFaceBook(new BirthdayGreetings(), "Sanjay");
	System.out.println("-----------");
	postInFaceBook(new GraduationWishes(), "Sanjay");
	
	Greet g=(String n) -> {
		return "Hi "+n+" with u many many happy returns of the day !!!!!";
	};
	postInFaceBook(g, "Arun");
	
	Greet g1=n-> "Hello "+n+" Happy Birthday Enjoy !!!!";
	postInFaceBook(g1, "Kartik");
	
	System.out.println("-----");
	postInFaceBook((String n) -> {
		return "Hi "+n+" with u many many happy returns of the day !!!!!";
	}, "Lakshmanan");

}

static void postInFaceBook(Greet g,String name) {
	System.out.println(g.wish(name));
}
}
//its a functional interface --> must have one and only abstract method
interface Greet{
	String wish(String n);
	//void f1();
}
class BirthdayGreetings implements Greet{
	public String wish(String n) {
		return "Hi "+n+" with u many many happy returns of the day !!!!!";
	}
}
class GraduationWishes implements Greet{
	public String wish(String n) {
		return "hi "+n+" All the best";
	}
	
}