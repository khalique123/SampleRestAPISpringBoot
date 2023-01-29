package com.example.demo.test.intergration;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.controller.EmployeeController;
import com.example.demo.model.Employee;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerIntegrationTests {
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	EmployeeController employeeController;

	Employee RECORD_1 = new Employee("Name1", "Role1");
	Employee RECORD_2 = new Employee("Name2", "Role2");
	Employee RECORD_3 = new Employee("Name3", "Role3");

	@Test
	public void getRecordsByName_success() throws Exception {
		List<Employee> records = new ArrayList<>(Arrays.asList(RECORD_1));

		Mockito.when(employeeController.get("Name1")).thenReturn(records);

		mockMvc.perform(MockMvcRequestBuilders
				.get("/employees/Name1")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(1)))
		.andExpect(jsonPath("$[0].name", is("Name1")));
	}

	@Test
	public void getAllRecords_success() throws Exception {
		List<Employee> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));

		Mockito.when(employeeController.all()).thenReturn(records);

		mockMvc.perform(MockMvcRequestBuilders
				.get("/employees/")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(3)))
		.andExpect(jsonPath("$[0].name", is("Name1")));
	}
}