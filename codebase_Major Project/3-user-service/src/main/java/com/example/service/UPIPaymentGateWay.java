package com.example.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class UPIPaymentGateWay implements PaymentGateWay {

	@Override
	public String pay() {
		// TODO Auto-generated method stub
		return "UPI Gate Way !!!";
	}

}
