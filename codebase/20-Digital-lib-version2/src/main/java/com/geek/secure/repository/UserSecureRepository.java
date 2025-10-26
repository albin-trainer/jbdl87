package com.geek.secure.repository;
import org.springframework.data.repository.CrudRepository;

import com.geek.entity.User;


public interface UserSecureRepository extends CrudRepository<User, Integer> {
    User findByUserName(String username);
}