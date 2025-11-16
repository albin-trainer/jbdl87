package com.example.service;

import com.example.entity.Wallet;

public interface WalletService {
	boolean isPresent(int userId);
	Wallet addNewWallet(Wallet w);
}
