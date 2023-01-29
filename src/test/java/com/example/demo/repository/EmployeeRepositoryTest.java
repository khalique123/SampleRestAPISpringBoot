package com.example.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.model.Employee;

@DataJpaTest
class EmployeeRepositoryTest {
	@Autowired
	private EmployeeRepository underTest;

	@Test
	void itShouldCheckIfEmployeeExistsByName() {
		//given
		String name = "name1";
		Employee employee = new Employee(name, "Role1");

		underTest.save(employee);

		//when
		List<Employee> employeeList = underTest.findAllByName(name);

		//then
		assertThat(employeeList).isNotEmpty();
	}

	@AfterEach //use this annotation on the method you want to run after each test
	void tearDown() {
		underTest.deleteAll();
	}
}
