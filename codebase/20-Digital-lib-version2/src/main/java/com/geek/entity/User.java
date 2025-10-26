package com.geek.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity @Data
public class User {
	@Id
private int userId;
private String firstName; 
@NotBlank(message =  "must enter last name")
private String lastName;
@Column(unique = true)
private String email;
}
