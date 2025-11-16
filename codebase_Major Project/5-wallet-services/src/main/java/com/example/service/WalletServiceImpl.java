package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.entity.Wallet;
import com.example.exception.ApplicationException;
import com.example.repo.WalletRepo;

@Service
public class WalletServiceImpl implements WalletService {
	@Autowired
	private WalletRepo walletRepo;
	@Autowired
	private RestTemplate template;
	@Value("${welcomeOffer}")
	private float welcomeOffer;
	
	@Override
	public boolean isPresent(int userId) {
		 //make a call to the user-service for verification
		String url="http://3-user-service/verifyuser/"+userId;
		boolean isPresent=template.getForObject(url, Boolean.class);
		return isPresent;
	}

	@Override
	public Wallet addNewWallet(Wallet w) {
		if(isPresent(w.getUserId())) {
			//add new wallet
			w.setWalletBalance(welcomeOffer);
			walletRepo.save(w);
		}
		else
			throw new ApplicationException("User id is incorrect");
		return w;
	}

}
