package com.example.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoApplicationSmokeTests {

	@Autowired
	private EmployeeController employeeController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(employeeController).isNotNull();
	}
}