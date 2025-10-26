package com.geek.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geek.dto.BorrowDto;
import com.geek.entity.Book;
import com.geek.entity.User;
import com.geek.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserApi {
	@Autowired
	private UserService userService;
//	@PostMapping
//	public User addNewUser(@Valid  @RequestBody  User u) {
//		return userService.addNewUser(u);
//	}
	@PostMapping("borrowbook")
	public Book borrowBook(@RequestBody BorrowDto borrowDto) {
	   return userService.borrowBook(borrowDto);
   }
	@PutMapping("returnbook/{id}")
	public Book returnBook(@PathVariable("id")  int tid) {
		return userService.returnBook(tid);
	}

}
