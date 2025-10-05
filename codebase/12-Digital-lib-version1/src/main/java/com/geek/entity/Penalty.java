package com.geek.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity @Data
public class Penalty {
	@Id @GeneratedValue
private int penaltyId;
private int noOfDaysDiff;
private float amt;
private String description;
}
