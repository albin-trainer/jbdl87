package com.geek.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.geek.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
    // Custom finder method to get user by username
    User findByUserName(String userName);
}
