package com.geek.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
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
import org.springframework.beans.factory.annotation.Autowired;

import com.geek.entity.Authour;
import com.geek.entity.Book;
import com.geek.entity.Genre;
import com.geek.entity.Penalty;
import com.geek.entity.Transaction;
import com.geek.entity.TransactionType;
import com.geek.repository.BookRepository;
import com.geek.repository.PenaltyRepository;
import com.geek.repository.TransactionRepository;
import com.geek.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
	@Mock
	private BookRepository bookRepo;
	@Mock
	private UserRepository userRepo;
	@Mock
	private TransactionRepository transRepo;
	@Mock
	private PenaltyRepository penaltyRepo;
	@InjectMocks
	private UserServiceImpl userService;
	@Test
	public void testReturnBookWithoutPenalty() {
		Book mockBook=new Book(1,"myBook","MockBook",200,LocalDate.of(2024, 10,10),10,Genre.COMEDY, new Authour());
		Transaction mockTransaction= new Transaction();
		mockTransaction.setTransactionId(991);
		mockTransaction.setTransactionType(TransactionType.BORROW);
		//mockTransaction.setAmt(100);
		mockTransaction.setBorrowedDate(LocalDate.of(2025, 10, 20));
		mockTransaction.setBook(mockBook);
	
		when(transRepo.findById(991)).thenReturn(Optional.of(mockTransaction));
		when(bookRepo.findById(1)).thenReturn(Optional.of(mockBook));
		Book b= userService.returnBook(991);
		assertEquals(TransactionType.RETURN, mockTransaction.getTransactionType().RETURN);
		assertEquals(200, mockTransaction.getAmt());
		assertEquals(LocalDate.now(), mockTransaction.getReturnedDate());
	}
	
	@Test
	public void testReturnBookWithPenalty() {
		Book mockBook=new Book(1,"myBook","MockBook",200,LocalDate.of(2024, 10,10),10,Genre.COMEDY, new Authour());
		Transaction mockTransaction= new Transaction();
		mockTransaction.setTransactionId(991);
		mockTransaction.setTransactionType(TransactionType.BORROW);
		//mockTransaction.setAmt(100);
		mockTransaction.setBorrowedDate(LocalDate.of(2025, 9, 24));
		mockTransaction.setBook(mockBook);
		when(transRepo.findById(991)).thenReturn(Optional.of(mockTransaction));
		when(bookRepo.findById(1)).thenReturn(Optional.of(mockBook));
		Book b= userService.returnBook(991);
		assertEquals(300, mockTransaction.getAmt());
		Penalty p=mockTransaction.getPenalty();
		assertEquals(p.getDescription(), "Late Fees");
		assertEquals(p.getAmt(), 100);
		assertEquals(b.getStock(), 11);
		verify(penaltyRepo,times(1)).save(any(Penalty.class));
		verify(transRepo,times(1)).save(any(Transaction.class));

		verify(bookRepo,times(1)).save(any(Book.class));

		
		

	}
	
}
