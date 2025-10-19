package com.geek.secure.controller;

import com.geek.secure.config.JwtTokenUtil;
import com.geek.secure.model.JwtRequest;
import com.geek.secure.model.JwtResponse;
import com.geek.secure.model.User;
import com.geek.secure.model.UserDto;
import com.geek.secure.service.JwtUserDetailsService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.Authentication;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@PostMapping("/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		System.out.println("authenticating ..");
	//	authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
	   //STEP1 - Authenticating ....
		Authentication authentication  =authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));

		System.out.println("authentication success...");

		//final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		UserDetails user = (UserDetails) authentication.getPrincipal();
		//UserDetails user = (UserDetails) authentication.getPrincipal();
		 String roles=userDetailsService.getRoles();
		 roles = roles.replace("[", "").replace("]", "");
         //GENERATE TOKEN
		String token = jwtTokenUtil.generateToken(user,roles);
		//final String token = jwtTokenUtil.generateToken(userDetails);
		// String roles=userDetailsService.getRoles();
		//Send to client as response
		return ResponseEntity.ok(new JwtResponse(token,roles));
	}

	@PostMapping("/register")
	public ResponseEntity<?> saveUser(
			@RequestBody @Valid UserDto user) throws Exception {
		User userDto= userDetailsService.save(user);
		return ResponseEntity.ok(userDto);
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
