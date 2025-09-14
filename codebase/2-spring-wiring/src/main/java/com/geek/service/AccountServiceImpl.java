package com.geek.service;
import com.geek.rep.AccountRep;
public class AccountServiceImpl  implements AccountService{
	public AccountServiceImpl() {
		System.out.println("Acc service constructor");
	}
	private AccountRep rep=null;
	public void setRep(AccountRep rep) {
		System.out.println("service setter");
		this.rep = rep;
	}
	public String creditService(float amt) {
		return rep.credit(amt);
	}
}
