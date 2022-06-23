package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.UserService;

@Controller
public class Signupcontroller {
	
	
	@Autowired
	private UserRepo userrepo;
	
	@GetMapping("/signupform")
	public String getsignup() {
		return "signup";
	}
	
	@PostMapping("/signupform")
	public String saveUser(@ModelAttribute User user)
	{
		//save user in db 
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		// spring data JPA
		
		userrepo.save(user);
		
		return "loginform";
	}

}
