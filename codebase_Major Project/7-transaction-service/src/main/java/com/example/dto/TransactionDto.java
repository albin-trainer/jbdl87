package com.example.dto;

import lombok.Data;

@Data
public class TransactionDto {
 private int  fromWalletId;
 private int toWalletId;
 private float amtToTransfer;
}
