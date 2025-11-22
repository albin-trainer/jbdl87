package com.example.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.constrants.AppConstants;
import com.example.dto.MessageDto;
import com.example.dto.UserDto;
import com.example.entity.User;
import com.example.repo.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private KafkaTemplate<String, String> template;
	@Autowired
	private ObjectMapper objectMapper; //comes from jackson lib (to bind json to java obj and vice versa)
	
	@Override
	public User addNewService(UserDto dto) {
		User user=new User();
		BeanUtils.copyProperties(dto, user);
		MessageDto msgDto=new MessageDto();
		
		//send to TOPIC ....
		User u=userRepo.save(user);
		msgDto.setUserId(u.getUserId());
		msgDto.setUserName(dto.getUserName());
		msgDto.setEmail(dto.getEmail());
		msgDto.setMsg("User added Successfully");
		try {
			String jsonText=objectMapper.writeValueAsString(msgDto);
			template.send(AppConstants.ADD_USER, dto.getUserName(), jsonText);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public boolean checkUserAvailability(int id) {
		Optional<User> optUser=   userRepo.findById(id);
		if(optUser.isPresent())
			return true;
		return false;
	}

}
