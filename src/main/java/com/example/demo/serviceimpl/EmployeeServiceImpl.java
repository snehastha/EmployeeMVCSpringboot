package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepo;
import com.example.demo.service.IEmployeeService;

@Service
public class EmployeeServiceImpl  implements IEmployeeService{
	
	@Autowired
	private EmployeeRepo empRepo;

	@Override
	public void addEmp(Employee employee) {
		empRepo.save(employee);
		
	}

	@Override
	public void deleteEmp(Long id) {
		empRepo.deleteById(id);
		
	}

	@Override
	public Employee getById(Long id) {
		
		return empRepo.getById(id);
	}

	@Override
	public List<Employee> getAll() {
		
		return empRepo.findAll(); //database bata data tanxa findall le
	}

	@Override
	public void updateEmp(Employee employee) {
		empRepo.save(employee);
		
	}

}
