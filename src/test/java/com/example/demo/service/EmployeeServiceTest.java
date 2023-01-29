package com.example.demo.service;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.repository.EmployeeRepository;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

	@Mock
	private EmployeeRepository employeeRepository;

	private EmployeeService underTest;

	@BeforeEach 
	public void setUp(){
		this.underTest = new EmployeeService(employeeRepository);
	}

	@Test
	void canGetAllEmployeesByRole() {
		String name = "Name1";

		//when
		underTest.findAllByName(name);

		//then
		verify(employeeRepository).findAllByName(name);
	}
}