package com.geek.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class User {
private int id;
private String userName;
private String password;
private String email;
}
