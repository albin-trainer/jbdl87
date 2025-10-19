package com.geek.secure.model;
public class JwtResponse{

	private final String jwttoken;
    private String role;
	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}
	public JwtResponse(String jwttoken, String role) {
		this.jwttoken = jwttoken;
		this.role = role;
	}

	public String getToken() {
		return this.jwttoken;
	}

	public String getRole() {
		return role;
	}
	
}