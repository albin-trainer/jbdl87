package com.geek.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.geek.entity.User;
import com.geek.repo.UserRepository;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Save a new user (encode password before saving)
    public User saveUser(User user) {
        // Encode the password before persisting
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    // Find a user by username
    public User getUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
