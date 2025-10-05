package com.geek.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity @Data
public class Transaction {
	@Id @GeneratedValue //auto generate
private int transactionId;
	private LocalDate borrowedDate;
	private LocalDate returnedDate;
	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;
	private float amt;
	@ManyToOne @JoinColumn(name="userId")
	private User user;
	@ManyToOne@JoinColumn(name="bookId")
	private Book book;
	@ManyToOne@JoinColumn(name="penaltyId")
	private Penalty penalty;
}
