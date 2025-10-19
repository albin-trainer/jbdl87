package com.geek.secure.repository;
import org.springframework.data.repository.CrudRepository;


import com.geek.secure.model.User;
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}