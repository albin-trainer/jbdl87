package com.example.service;

import com.example.dto.UserDto;
import com.example.entity.User;

public interface UserService {
 User addNewService(UserDto dto);
 boolean checkUserAvailability(int id);
}
