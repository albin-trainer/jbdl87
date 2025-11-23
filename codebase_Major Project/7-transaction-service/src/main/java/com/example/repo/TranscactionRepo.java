package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Transaction;

public interface TranscactionRepo extends JpaRepository<Transaction, Integer> {

}
