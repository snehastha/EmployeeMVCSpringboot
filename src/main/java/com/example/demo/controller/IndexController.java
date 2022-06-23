package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

// controller is used to handle http requests
public class IndexController {
	
	

//@RequestMapping(value = "/" , method = RequestMethod.GET)
	@GetMapping("/")
	public String showIndexpage() {
		
		return "loginform";
	}

}
