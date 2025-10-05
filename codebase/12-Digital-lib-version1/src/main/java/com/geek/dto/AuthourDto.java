package com.geek.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class AuthourDto {

private int authourId;
	@NotBlank(message = "Authour name cannnot be blank")
private String authourName;
}
