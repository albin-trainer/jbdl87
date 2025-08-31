package com.geeks.oops.part2;
public class InterfacesDemo {
public static void main(String[] args) {
	final int x=10; //constnt value
	//x++;
	Class c="".getClass();
	driving(new Nexon());
	System.out.println("------------");
	Verna verna=new Verna();
	driving(verna);
}
   static void driving(Driveable driver) {
	   //pure polymorphism .....
	   driver.gear(); //driver not worried abt which car to drive .....
   }
}
interface Driveable{
	int MAX_SPEED=150;//public static final 
	void gear(); //public abstract void gear();
}
class Nexon implements Driveable{
	@Override //to ensure v override 
	public void gear() {
		System.out.println("Nexon Gear program gets started");
	}
	
}
class Verna implements Driveable{
	public void gear() {
		System.out.println("Verna Gear program gets started");
	}
}