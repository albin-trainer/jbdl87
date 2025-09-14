package com.geek.rep;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Primary
public class CreditCardRep implements AccountRep {

	@Override
	public String credit(float amt) {
		// TODO Auto-generated method stub
		return "Hi your credit card due is settled for the amt "+amt;
	}

}
