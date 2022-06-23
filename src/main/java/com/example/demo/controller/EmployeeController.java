package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Employee;
import com.example.demo.service.IEmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private IEmployeeService service;
	
	
	@GetMapping("/employee")
	public String getEmployeeForm(HttpSession session) {
		if(session.getAttribute("user")==null) {
			return "loginform";
		}
		
		return "employeeform";
		
	}
	
	@PostMapping("/employee")
	public String postEmployee(@ModelAttribute Employee emp,HttpSession session) {
		
		if(session.getAttribute("user")==null) {
			return "loginform";
		}
		
		service.addEmp(emp);
		return "employeeform";
	}
	
	@GetMapping("/list")
	public String getAllEmp(Model model,HttpSession session) {
		
		if(session.getAttribute("user")==null) {
			return "loginform";
		}
		
		model.addAttribute("emplist",service.getAll());
		
		return"employeeList";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam Long id,HttpSession session) {
		if(session.getAttribute("user")==null) {
			return "loginform";
		}
		
		service.deleteEmp(id);
		return"redirect:list";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam Long id,Model model,HttpSession session)
	{
		if(session.getAttribute("user")==null) {
			return "loginform";
		}
		
		model.addAttribute("emodel",service.getById(id));
		

		return"editform";
	}
	@PostMapping("/update")
	public String update(@ModelAttribute Employee emp,HttpSession session) {
		if(session.getAttribute("user")==null) {
			return "loginform";
		}
		
		service.updateEmp(emp);
		return "redirect:list";
	} 
	
	
	
	

}
