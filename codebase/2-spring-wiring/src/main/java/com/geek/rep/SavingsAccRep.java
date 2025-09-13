package com.geek.rep;
public class SavingsAccRep implements AccountRep {
public SavingsAccRep() {
	System.out.println("Savings acc constructor");
}
	public String credit(float amt) {
		return "Hi the amt of "+amt+" credited in ur savings acc";
	}
}
