package com.example.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Wallet;
import com.example.service.WalletService;

@RestController
@RequestMapping("/wallet")
public class WalltetApi {
	private Logger log=LoggerFactory.getLogger(WalltetApi.class);
	
	@Autowired
	private WalletService walletService;

	
	@PostMapping
	public Wallet addNewWallet(@RequestBody  Wallet w) {
		log.info("Adding new Wallet {} ",w.getUserId());
		return walletService.addNewWallet(w);
	}
	@GetMapping("/{userId}")
	public boolean isPresent(@PathVariable("userId") int userId) {
		log.info("searching the user {}",userId);
		return walletService.isPresent(userId);
	}
}
