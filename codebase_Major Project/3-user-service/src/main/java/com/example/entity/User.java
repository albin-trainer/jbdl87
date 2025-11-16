package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {
	@Id
	@GeneratedValue
private int userId;
	private String userName;
	private String password;
	private String address;
	private String email;
	private int phoneNumber;
}
