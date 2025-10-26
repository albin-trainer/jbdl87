package com.geek.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Authour {
	@Id
private int authourId;
	@NotBlank(message = "Authour name cannnot be blank")
private String authourName;
}
