package com.example.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDto {
	@NotBlank(message = "Must enter username")
	private String userName;
	private String password;
	private String address;
	private String email;
	private int phoneNumber;
}
