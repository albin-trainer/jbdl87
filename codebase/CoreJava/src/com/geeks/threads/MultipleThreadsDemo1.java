package com.geeks.threads;

public class MultipleThreadsDemo1 {
public static void main(String[] args) {
	System.out.println("Main thread started ....");
	Thread mainThread=Thread.currentThread();
	mainThread.setPriority(10);
	Task1 task=new Task1();
	Thread t=new Thread(task); //new thread 
	t.setPriority(5);
	t.start();  //Runnable state
	//right answer -->CANT predict
	for(int i=1;i<=1000;i++) {
		System.out.println("Main : "+i);
	}
	System.out.println("Main ends ...");
}
}


class Task1 implements Runnable{

	public void run() {
		System.out.println("A new thread started running .....");
		for(int i=1;i<=1000;i++) {
			System.out.println("Child : "+i);
		}
	}
}