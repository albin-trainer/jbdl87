package com.example.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Wallet {
	@Id @GeneratedValue
private int walletId;
private float walletBalance;
@CreationTimestamp
private LocalDate createdDate;
@UpdateTimestamp
private LocalDate lastUpdatedDate;

private int userId; 
@Enumerated(EnumType.STRING)
private WalletStatus status;
}
