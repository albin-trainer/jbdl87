package com.geek.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.geek.entity.Book;
import com.geek.entity.Transaction;
import com.geek.entity.User;
@Service
public class UserServiceImpl implements UserService {

	@Override
	public User addNewUser(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book borrowBook() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book returnBook(int tid) {
		// TODO Auto-generated method stub
		return null;
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
