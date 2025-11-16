package com.example.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class MockGateWay implements PaymentGateWay {

	@Override
	public String pay() {
		// TODO Auto-generated method stub
		return "Mock GateWay !!!";
	}

}
