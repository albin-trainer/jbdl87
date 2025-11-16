package com.example.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Wallet;
import com.example.service.WalletService;

@RestController
@RequestMapping("/wallet")
public class WalltetApi {
	@Autowired
	private WalletService walletService;
	@PostMapping
	public Wallet addNewWallet(@RequestBody  Wallet w) {
		return walletService.addNewWallet(w);
	}
}
