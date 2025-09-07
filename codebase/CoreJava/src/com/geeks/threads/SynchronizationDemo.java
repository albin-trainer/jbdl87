package com.geeks.threads;

public class SynchronizationDemo {
public static void main(String[] args) throws InterruptedException {
	Bank bank=new Bank();
	Thread upi=new Thread(bank,"UPI");
	Thread atm=new Thread(bank,"ATM");
	upi.start();
	atm.start();
	upi.join(); atm.join(); //waits for these threads to completed ...
	System.out.println("Final balance "+bank.getBankBalance());
}
}

class Bank implements Runnable{
	private float bankBalance=5000;
	public void run() {
			debit(3000);
	}
	private synchronized void debit(float debitAmt) {
		if(bankBalance>=debitAmt && bankBalance>=0) {
			System.out.println(Thread.currentThread().getName()+" ready to debit");
			try {
				//Thread.sleep(1000);
				wait(1000); //releases the lock & goes to block state
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			bankBalance-=debitAmt;
			System.out.println(Thread.currentThread().getName()+" Transction success");
		}
		else
			System.out.println(Thread.currentThread().getName()+" Insufficient funds ..");
	}
	public float getBankBalance() {
		return bankBalance;
	}
	
}