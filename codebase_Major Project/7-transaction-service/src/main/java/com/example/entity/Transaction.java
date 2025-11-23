package com.example.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class Transaction {
	@Id @GeneratedValue
private int transactionId;
private int  fromWalletId;
private int toWalletId;
@CreationTimestamp 
private LocalDateTime time;
private float amt;
}
