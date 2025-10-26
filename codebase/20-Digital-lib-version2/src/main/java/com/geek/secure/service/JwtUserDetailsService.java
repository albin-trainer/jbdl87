package com.geek.secure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.geek.entity.User;
import com.geek.secure.model.UserDto;
import com.geek.secure.repository.UserSecureRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private UserSecureRepository userDao;
	@Autowired
	private PasswordEncoder bcryptEncoder;
	private String roles;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("---load by  uname "+username);
		List<SimpleGrantedAuthority> roles = null;
		User user = userDao.findByUserName(username);
		System.out.println("done.. "+user.getUserName());
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		roles = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
		System.out.println("Roles : "+roles);
		setRoles(roles.toString());
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
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
		newUser.setUserName(user.getUserName());
		
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		
		newUser.setRole(user.getRole());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setEmail(user.getEmail());
		newUser.setUserId(user.getUserId());
		return userDao.save(newUser);
	}
}