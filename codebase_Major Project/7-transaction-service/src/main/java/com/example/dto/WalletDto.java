package com.example.dto;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
@Data
public class WalletDto {
	private int walletId;
	private float walletBalance;
	private LocalDate createdDate;
	private LocalDate lastUpdatedDate;
	private int userId; 
	private String status;
}
