package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {
	
	void userSignup(User user);
	
	User login(String un ,String psw);

}
