package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface IEmployeeService {
	
	void addEmp(Employee employee);
	
	void deleteEmp(Long id);
	
	Employee getById(Long id);
	
	List<Employee> getAll();
	
	void updateEmp(Employee employee);

}
