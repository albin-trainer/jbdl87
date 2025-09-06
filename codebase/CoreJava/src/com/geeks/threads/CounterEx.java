package com.geeks.threads;

public class CounterEx {
public static void main(String[] args) throws InterruptedException {
	 Counter c=new Counter();
	 Thread t1=new Thread(c);
	 Thread t2=new Thread(c);
	 Thread t3=new Thread(c);
	 t1.start(); t2.start();  t3.start();
	 t1.join(); t2.join(); t3.join(); //ensure all 3 threads job got over
	 System.out.println("Final count value : "+c.getCount());
}
}
class Counter implements Runnable{
	int count;
	public void run() { /// this method will get executed by 3 threads
		for(int i=1;i<=10000;i++) {
		synchronized(this) {//this block gets executed by only 1 thread 
					count++;
			}
		}
	}
	int getCount() {
		return count;
	}
}