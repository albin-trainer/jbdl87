package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private Logger log=LoggerFactory.getLogger(WalletServiceImpl.class);
	@Override
	public boolean isPresent(int userId) {
		log.info("Making a call to user service {} ", userId);
		 //make a call to the user-service for verification
		String url="http://3-user-service/verifyuser/"+userId;
		//NEW  HTTP REQUEST to the user service
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
