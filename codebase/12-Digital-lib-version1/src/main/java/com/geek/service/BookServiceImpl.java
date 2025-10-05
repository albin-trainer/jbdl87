package com.geek.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.geek.dto.AuthourDto;
import com.geek.dto.BookDto;
import com.geek.entity.Authour;
import com.geek.entity.Book;
import com.geek.entity.Genre;
import com.geek.exceptions.ApplicationException;
import com.geek.repository.AuthourRepository;
import com.geek.repository.BookRepository;
@Service
public class BookServiceImpl implements BookService {
   @Autowired
	private AuthourRepository authRepo;
   @Autowired
   private BookRepository bookRepo;
	@Override
	public Authour addAuthour(AuthourDto authourDto) {
		Authour authour=new Authour();
		//copy all properties from dto to entity 
		BeanUtils.copyProperties(authourDto, authour);
		return authRepo.save(authour);
	}

	@Override
	public Book searchBookById(int bookId) {
		
		return null;
	}

	@Override
	public Book addBook(BookDto bookDto) {
		int authourId=bookDto.getAuthourId();
		Optional<Book> optionalBook=   bookRepo.findById(bookDto.getBookId());
		if(optionalBook.isPresent()) {
			throw new ApplicationException("Book already present");
		}
		//searching only by Primary key ....
		Optional<Authour> optionalAuthour=  authRepo.findById(authourId);
		if(optionalAuthour.isPresent()) {
			Book book=new Book();
			book.setAuthour(optionalAuthour.get());
			//copy other properties from dto to entity
			BeanUtils.copyProperties(bookDto, book);
			return bookRepo.save(book); //insert or update ....
		}
		//throw exception ....authour not found ....
		return null;
	}

	@Override
	public List<Book> searchByGenre2(Genre genre) {
		return null;
	}

	@Override
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}

	@Override
	public Page<Book> allBookswithPagination(int pageNo, int size) {
		return null;
	}

	@Override
	public List<Book> searchByAuthour(int authourId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> searchByGenre(Genre genre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeBook(int bookId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Book> searchByBookName(String bookName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateCost(int bookId, float cost) {
		// TODO Auto-generated method stub
		return 0;
	}

}
