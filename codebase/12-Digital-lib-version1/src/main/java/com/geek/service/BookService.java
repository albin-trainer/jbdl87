package com.geek.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.geek.dto.AuthourDto;
import com.geek.dto.BookDto;
import com.geek.entity.Authour;
import com.geek.entity.Book;
import com.geek.entity.Genre;



public interface BookService {

Authour addAuthour(AuthourDto authourDto);
Book searchBookById(int bookId);
Book addBook(BookDto bookDto);
List<Book> searchByGenre2(Genre genre);
List<Book> allBooks();
Page<Book> allBookswithPagination(int pageNo,int size);
List<Book> searchByAuthour(int authourId);
List<Book> searchByGenre(Genre genre);
//Book updateBook(BookDto book,int bookId);
void removeBook(int bookId);

List<Book> searchByBookName(String bookName);
public int updateCost(int bookId, float cost);
}
