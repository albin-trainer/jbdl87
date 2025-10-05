package com.geek.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geek.entity.Penalty;

public interface PenaltyRepository extends JpaRepository<Penalty, Integer> {

}
