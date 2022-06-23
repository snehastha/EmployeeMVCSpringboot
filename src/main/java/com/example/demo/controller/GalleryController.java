package com.example.demo.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GalleryController {
	
	@GetMapping("/gallery")
	public String gallery(Model model) {
		
		File folder = new File("/springmvcproject/src/main/resources/static/images");
		String[] imageNames = folder.list();
		
		model.addAttribute("imgNames",imageNames);
		return"gallery";
		
	}

}
