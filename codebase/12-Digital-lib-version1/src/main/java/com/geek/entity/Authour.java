package com.geek.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Authour {
	@Id
private int authourId;
private String authourName;
}
