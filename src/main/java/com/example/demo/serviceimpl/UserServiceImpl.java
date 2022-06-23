package com.example.demo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.UserService;

public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userrepo;

	@Override
	public void userSignup(User user) {
		userrepo.save(user);
		
	}

	@Override
	public User login(String un, String psw) {
		
		return userrepo.findByUsernameAndPassword(un,psw);
	}

}
