package com.geek;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
class UserServiceTest {
   @Mock//creates the mock obj of userrepo
	private UserRepository userRepo;
	@InjectMocks// injects the mock objs in service
   private UserService service;
	
	@Test
	void testGetUserNameInUpperCase() {
		//Pre condition
				//if userRep.findById(101) gets called
				//   --> return a user object 
				User mockUser=new User(101,"Anshi",true);
				when(userRepo.findById(101)).thenReturn(mockUser);
			String name=service.getUserNameInUpperCase(101);
			assertEquals("ANSHI", name);
			//to verify that the service really called findById of repo once
			verify(userRepo,times(1)).findById(101);
	}

	@Test
	void testGetAllPremiumUsers() {
		List<User> mockUsers=Arrays.asList( new User(101,"Anshi",true),
				 new User(102,"Abhijeet",true),
				 new User(103,"Balaram",false),
				 new User(104,"Bhumika",true),
				 new User(105,"Deepansh",true),
				 new User(106,"Devyani",false)
				);
	when(userRepo.getAllUsers()).thenReturn(mockUsers);
	List<String> names=   service.getAllPremiumUsers();
	assertEquals(4, names.size());
	assertEquals(true, names.contains("Abhijeet"));
	assertEquals(false, names.contains("Devyani"));
	}

	@Test
	void testChkForPremium() {
		//Pre Condition
	User mockUser= new User(101,"Devyani",false);
	User mockUser2= new User(102,"Abhijeet",true);
		when(userRepo.findById(101)).thenReturn(mockUser);
		when(userRepo.findById(102)).thenReturn(mockUser2);
		boolean isPremium=service.chkForPremium(101);
		assertEquals(false,isPremium);
		isPremium=service.chkForPremium(102);
		assertEquals(true,isPremium);
		verify(userRepo, times(1)).findById(101);
		verify(userRepo, times(1)).findById(102);
	}

}
