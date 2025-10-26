package com.geek.secure.model;

import java.io.Serializable;

public class JwtRequest {
	private String userName;
	private String password;
	
	//default constructor for JSON Parsing
	public JwtRequest()
	{
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	
}