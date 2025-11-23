package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.example.dto.TransactionDto;
import com.example.dto.WalletDto;
import com.example.entity.Transaction;
import com.example.repo.TranscactionRepo;

@Service
public class TransactionService {
	@Autowired

	TranscactionRepo repo;
	@Autowired
	 RestTemplate restTemplate;
	public Transaction fundTransfer( TransactionDto dto) {
		//make a call to wallet service to check whether the sufficient amt present or not
		String url1="http://5-wallet-services/wallet/"+dto.getFromWalletId();
		String url2="http://5-wallet-services/wallet/"+dto.getToWalletId();
		WalletDto fromWallet=  restTemplate.getForObject(url1, WalletDto.class);
		WalletDto toWallet=  restTemplate.getForObject(url2, WalletDto.class);
		if(fromWallet !=null && toWallet !=null) {
			if(fromWallet.getWalletBalance()>=dto.getAmtToTransfer()) {
				// debit from fromwallet and
				fromWallet.setWalletBalance(fromWallet.getWalletBalance()-dto.getAmtToTransfer());
				toWallet.setWalletBalance(toWallet.getWalletBalance()+dto.getAmtToTransfer());
				updateWallet(fromWallet);
				updateWallet(toWallet);
				Transaction  t= new Transaction();
				t.setFromWalletId(fromWallet.getWalletId());
				t.setToWalletId(toWallet.getWalletId());
				t.setAmt(dto.getAmtToTransfer());
				return repo.save(t);
				//credit to toWallet
				//Create a Transaction object
				 //call setters
				 //save it 
				 //return Transaction object
			}
		}
		return null;
	}
	public void updateWallet(WalletDto walletDto) {
		//call wallet service
		String url="http://5-wallet-services/wallet/";
	     	restTemplate.put(url, walletDto);
	}
}