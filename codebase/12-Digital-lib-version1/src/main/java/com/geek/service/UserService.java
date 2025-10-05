package com.geek.service;

import java.util.List;

import com.geek.entity.Book;
import com.geek.entity.Transaction;
import com.geek.entity.User;

public interface UserService {
	User addNewUser(User u);
	//need later....
   Book borrowBook(); //dto
	Book returnBook(int tid);
	boolean checkAvailability(int bookId);
	List<Transaction>  chkTransactionByUser(int userId);
}
