package com.geek.secure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.geek.secure.model.User;
import com.geek.secure.model.UserDto;
import com.geek.secure.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userDao;
	@Autowired
	private PasswordEncoder bcryptEncoder;
	private String roles;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("---load by  uname ");
		List<SimpleGrantedAuthority> roles = null;
		User user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		roles = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
		System.out.println("Roles : "+roles);
		setRoles(roles.toString());
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				roles);
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public User save(UserDto user) {
		User newUser = new User();
		newUser.setUsername(user.getUsername());
		
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		
		newUser.setRole(user.getRole());
		return userDao.save(newUser);
	}
}