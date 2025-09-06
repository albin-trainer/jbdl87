package com.geeks.threads;
public class JoinDemo1 {
public static void main(String[] args) throws InterruptedException {
	System.out.println("Main started ..");
	Task2 task=new Task2();
	Thread t=new Thread(task);
	t.start();
	//i want the final value of count ....
	//main shud wait for the child to complete the task ..
	//means i want the computation result of the child thread
	//t.join(); //waits for the child to complete the task
	t.join(5000);
	System.out.println(" Count : "+task.getCount());
	System.out.println("Main Ends ...");
}
}
class Task2 implements Runnable{
	private int count=0;
	//run() gets called whenever the scheduler 
	//selects to run
	public void run() { 
		for(int i=1;i<=10;i++) {
			System.out.println(i);
			count++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	int getCount() {
		return count;
	}
	
}