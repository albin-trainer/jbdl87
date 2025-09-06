package com.geeks.threads;

public class MainThreadDemo {
public static void main(String[] args) {
	System.out.println("Hello");
//	System.out.println(5/0);
	Thread t=Thread.currentThread(); //retuns the current running thread's reference ....
	System.out.println("current running thread is "+t.getName());
	System.out.println("priority "+t.getPriority());
	t.setName("Geek");
	t.setPriority(10); //can set priority bw 1(min) to 10 (max)
	System.out.println("current running thread is "+t.getName());
	System.out.println("priority "+t.getPriority());
	for(int i=1;i<=10;i++) {
		System.out.println(i);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

}
}
