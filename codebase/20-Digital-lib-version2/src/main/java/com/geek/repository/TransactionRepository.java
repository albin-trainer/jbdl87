package com.geek.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geek.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

}
