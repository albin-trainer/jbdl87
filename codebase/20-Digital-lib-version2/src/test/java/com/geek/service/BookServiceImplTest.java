package com.geek.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.geek.entity.Authour;
import com.geek.entity.Book;
import com.geek.entity.Genre;
import com.geek.repository.BookRepository;
@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {
	@Mock
	 private BookRepository bookRepo;
	@InjectMocks
	private BookServiceImpl bookService;
	@Test
	void testSearchBookById() {
		Book mockBook=new Book(1,"myBook","MockBook",100,LocalDate.of(2024, 10,10),10,Genre.COMEDY, new Authour());
		//PRE condition
		//repo.findById() returns Optional.of(Book)
		when(bookRepo.findById(1)).thenReturn(Optional.of(mockBook));
		Book b= bookService.searchBookById(1);
		assertEquals(b.getBookName(), mockBook.getBookName());
		assertEquals(b.getTitle(),mockBook.getTitle());
		verify(bookRepo,times(1)).findById(1);
	}
	@Test
	void testSearchBookByIdException() {
		
	}

}
