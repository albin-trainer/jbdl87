package com.geek.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geek.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
