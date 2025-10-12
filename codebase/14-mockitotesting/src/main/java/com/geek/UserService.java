package com.geek;

import java.util.List;
public class UserService {
	private UserRepository userRepo;
public UserService(UserRepository userRepo) {
	// TODO Auto-generated constructor stub
	this.userRepo=userRepo;
}
public String getUserNameInUpperCase(int id) {
	User user=userRepo.findById(id);
	if(user!=null) {
		return user.getName().toUpperCase();
	}
	return "Not Available";
	//return "ANSHI";
}
public List<String> getAllPremiumUsers(){
	return
	userRepo.getAllUsers().stream().
	filter(u->u.isPremium()).
	map(u->u.getName()).toList();
}
public boolean chkForPremium(int id) {
	User user=userRepo.findById(id);
	if(user.isPremium()) return true;
	else return false;
}

}
