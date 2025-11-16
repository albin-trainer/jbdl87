package com.example.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.UserDto;
import com.example.entity.User;
import com.example.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User addNewService(UserDto dto) {
		User user=new User();
		BeanUtils.copyProperties(dto, user);
		return userRepo.save(user);
	}

	@Override
	public boolean checkUserAvailability(int id) {
		Optional<User> optUser=   userRepo.findById(id);
		if(optUser.isPresent())
			return true;
		return false;
	}

}
