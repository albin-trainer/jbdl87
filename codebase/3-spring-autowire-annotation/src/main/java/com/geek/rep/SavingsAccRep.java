package com.geek.rep;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Component//("savings")
public class SavingsAccRep implements AccountRep {
public SavingsAccRep() {
	System.out.println("Savings acc constructor");
}
	public String credit(float amt) {
		return "Hi the amt of "+amt+" credited in ur savings acc";
	}
}
