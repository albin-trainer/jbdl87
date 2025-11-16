package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Wallet;

public interface WalletRepo extends JpaRepository<Wallet, Integer> {

}
