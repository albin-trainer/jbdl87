package com.geek.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {
	@Id
private int id;
private String userName;
private String password;
private String email;
private String role;
}
