package com.geek.secure.model;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data
public class UserDto {

private int userId;
	private String userName;
private String firstName; 
private String lastName;
@Column(unique = true)
private String email;

private String role;
private String password;
   
}
