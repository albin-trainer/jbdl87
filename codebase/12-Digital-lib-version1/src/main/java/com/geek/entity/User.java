package com.geek.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity @Data
public class User {
	@Id
private int userId;
private String firstName; 
private String lastName;
@Column(unique = true)
private String email;
}
