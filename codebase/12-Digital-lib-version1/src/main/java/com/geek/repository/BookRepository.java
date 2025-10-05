package com.geek.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geek.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
