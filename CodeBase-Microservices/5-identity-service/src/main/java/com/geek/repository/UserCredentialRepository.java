package com.geek.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geek.entity.UserCredential;

import java.util.Optional;

public interface UserCredentialRepository  extends JpaRepository<UserCredential,Integer> {
    Optional<UserCredential> findByUsername(String username);
}
