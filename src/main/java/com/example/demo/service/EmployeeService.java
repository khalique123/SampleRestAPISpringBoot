package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> all() {
		return employeeRepository.findAll();
	}

	public List<Employee> findAllByName(String role) {
		return employeeRepository.findAllByName(role);
	}

	public void save(Employee emp) {
		employeeRepository.save(emp);
	}

}
