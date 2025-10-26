package com.geek.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.geek.dto.BookDto;
import com.geek.entity.Book;
import com.geek.entity.Genre;
import com.geek.service.BookService;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/books")
public class BookApi {
	@Autowired
	private BookService bookService;
	@GetMapping("/{bookId}")
	public Book searchBookById(@PathVariable("bookId")  int bookId) {
		return bookService.searchBookById(bookId);
	}
	@PostMapping
	public ResponseEntity<Book> addNewBook( @RequestBody @Valid BookDto bookDto){
	Book book=	bookService.addBook(bookDto);
	return new ResponseEntity<Book>(book,HttpStatus.CREATED);
	}
	@GetMapping("/searchByAuthour/{authourId}")
	public List<Book> searchByAuthour(@PathVariable("authourId") int authourId){
		return bookService.searchByAuthour(authourId);
	}
	@GetMapping("/searchByGenre")
	public List<Book> searchByGenre( @RequestParam("genre") Genre genre){
		return bookService.searchByGenre(genre);
	}
	@GetMapping
	public List<Book> allBooks() {
		return bookService.allBooks();
	}
	@GetMapping("{pageNo}/{size}")
	public Page<Book> allBookswithPagination(@PathVariable("pageNo") int pageNo, @PathVariable("size") int size){
		return bookService.allBookswithPagination(pageNo, size);
	}
}
