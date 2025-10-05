package com.geek.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geek.entity.Authour;

public interface AuthourRepository extends JpaRepository<Authour, Integer> {

}
