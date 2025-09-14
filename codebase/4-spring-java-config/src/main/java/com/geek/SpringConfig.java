package com.geek;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.geek.rep.AccountRep;
import com.geek.rep.CreditCardRep;
import com.geek.rep.SavingsAccRep;
import com.geek.service.AccountService;
import com.geek.service.AccountServiceImpl;

@Configuration //replaces the xml file
@ComponentScan(basePackages = "com.geek")
public class SpringConfig {
	@Bean("service")  //ressembles <bean>
	//here method name can be anything .....
	public AccountService getAccountServiceImpl() {
		//this obj goes to ApplicationContext
		return new AccountServiceImpl();
	}
//	@Bean
//	public AccountRep getSavings() {
//		return new SavingsAccRep();
//	}
//	@Bean
//	public AccountRep getCreditCard() {
//		return new CreditCardRep();
//	}
}
