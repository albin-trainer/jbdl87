package com.geek.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.geek.rep.AccountRep;

@Component("service") //replaces <bean id="service" class="">
public class AccountServiceImpl  implements AccountService{
	public AccountServiceImpl() {
		System.out.println("Acc service constructor");
	}
	@Autowired
	@Qualifier("savingsAccRep")
	private AccountRep rep=null;
	
	//@Autowired
	/*
	 * public void setRep(AccountRep rep) { System.out.println("service setter");
	 * this.rep = rep; }
	 */
	public String creditService(float amt) {
		return rep.credit(amt);
	}
}
