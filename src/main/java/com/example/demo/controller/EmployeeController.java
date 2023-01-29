package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> all() {
		return employeeService.all();
	}

	@GetMapping("/employees/{name}")
	public List<Employee> get(@PathVariable("name") String name) {
		return employeeService.findAllByName(name);
	}
	
	@RequestMapping("/")
    public String home(){
        return "Hello World!";
    }
}
