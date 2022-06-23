package com.example.demo.controller;


import javax.servlet.http.HttpSession;

import org.apache.coyote.http11.Http11AprProtocol;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.UserService;

@Controller
public class LoginController {
	
 private static final  Logger logger = (Logger) LoggerFactory.logger(LoginController.class);
	
	@Autowired
	private UserRepo userrepo;
	
	@GetMapping("/login")
	public String getLogin() {
		
		return "loginform";
		
	}
	@PostMapping("/login")
	public String doLogin(@ModelAttribute User user,Model model ,HttpSession session) {
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		User usr=userrepo.findByUsernameAndPassword(user.getUsername(),user.getPassword());

		if(usr != null)
{
		logger.info("login success");
		
		session.setAttribute("user", usr);
		session.setMaxInactiveInterval(20);
	//	model.addAttribute("userName",user.getUsername());
		
		return "home";
}
		
		model.addAttribute("message", "user not found");

return "loginform";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "loginform";
		
	}
}
