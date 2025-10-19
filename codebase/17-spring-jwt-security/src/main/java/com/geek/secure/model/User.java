package com.geek.secure.model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "userlogin2")
public class User {
    @Id
    @GeneratedValue//(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    @NotNull(message = "username required")
    private String username;
    @Column
    @JsonIgnore
    private String password;
    private String role;
  
    public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}

