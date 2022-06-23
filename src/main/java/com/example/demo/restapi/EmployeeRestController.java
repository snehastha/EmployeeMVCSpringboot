package com.example.demo.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepo;
import com.example.demo.service.IEmployeeService;
import com.example.demo.serviceimpl.EmployeeServiceImpl;

@RestController
@RequestMapping("/api/emp")
public class EmployeeRestController {
	@Autowired
	private IEmployeeService service;
	
	
	@GetMapping("/list")
	public List<Employee> getAllEmp() {
		
		return service.getAll();
	}
	
	@PostMapping("/add")
	public String addEmp(@RequestBody Employee emp) {
		service.addEmp(emp);
		
		return "added success";
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
	service.deleteEmp(id);
		
		return"delete success";
		
	}

	@GetMapping("/{id}")
	public Employee getOne(@PathVariable Long id) {
		
		return service.getById(id);
	} 
	
	@GetMapping("j20")
	public String jsontoobject() {
		RestTemplate template = new RestTemplate();
		Employee emp=template.getForObject("", Employee.class);
		return"";
	}
}
