package com.geek.service;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geek.dto.BorrowDto;
import com.geek.entity.Book;
import com.geek.entity.Penalty;
import com.geek.entity.Transaction;
import com.geek.entity.TransactionType;
import com.geek.entity.User;
import com.geek.exceptions.ApplicationException;
import com.geek.repository.BookRepository;
import com.geek.repository.PenaltyRepository;
import com.geek.repository.TransactionRepository;
import com.geek.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private BookRepository bookRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private TransactionRepository transRepo;
	@Autowired
	private PenaltyRepository penaltyRepo;
	@Override
	public User addNewUser(User u) {
		return userRepo.save(u);
	}

	@Override
	public Book borrowBook(BorrowDto borrowDto) {
		User user=userRepo.
				findById(borrowDto.getUserId()).
				orElseThrow(() ->  new ApplicationException("user not found"));
		Book book =bookRepo.findById(borrowDto.getBookId())
				.orElseThrow(() ->  new ApplicationException("Book not found"));
		if(book.getStock()>0) {
			Transaction t=new Transaction();
			t.setBorrowedDate(LocalDate.now());
			t.setTransactionType(TransactionType.BORROW);
			t.setAmt(book.getCost());
			t.setUser(user);
			t.setBook(book);
			book.setStock(book.getStock()-1);
			bookRepo.save(book);
			transRepo.save(t);
		}
		else {
			throw new ApplicationException("Sorry No stocks for "+book.getBookName());
		}
		return book;
	}
	@Override
	public Book returnBook(int tid) {
		Transaction t=
				transRepo.findById(tid).orElseThrow(() -> new ApplicationException("tr id not found"));
//IF condtion to chk the transaction status is borrowed
		Book book=bookRepo.findById(t.getBook().getBookId()).get();
		LocalDate borrowedDate=	t.getBorrowedDate();
	  LocalDate currentDate=LocalDate.now();
	  //find the diff bw two dates ....
	  //java 8 datetime api
	  //here v shud pass LocalDateTime object
	  //atStartOfDay gives LocalDateTime object
	  Duration duration=Duration.between(borrowedDate.atStartOfDay(), currentDate.atStartOfDay());
	  long dateDiff= duration.toDays();
	  System.out.println("date diff : "+dateDiff);
		if(dateDiff<=30) {
			t.setReturnedDate(currentDate);
			t.setTransactionType(TransactionType.RETURN);
			t.setAmt(book.getCost());
		}
		else {
			Penalty p=new Penalty();
			p.setNoOfDaysDiff( (int) dateDiff);
			int penaltyDays=(int) (dateDiff-30);
			float penaltyAmt=penaltyDays*50;
			p.setAmt(penaltyAmt);
			p.setDescription("Late Fees");
			t.setReturnedDate(currentDate);
			t.setTransactionType(TransactionType.RETURN);
			t.setAmt(book.getCost()+penaltyAmt);
			t.setPenalty(p);
			penaltyRepo.save(p);
		}
		book.setStock(book.getStock()+1);
		bookRepo.save(book);
		transRepo.save(t);
		return book;
	}

	@Override
	public boolean checkAvailability(int bookId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Transaction> chkTransactionByUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
