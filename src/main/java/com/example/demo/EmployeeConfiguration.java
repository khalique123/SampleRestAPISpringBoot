package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Configuration
class EmployeeConfiguration {

	private static final Logger log = LoggerFactory.getLogger(EmployeeConfiguration.class);

	@Bean
	CommandLineRunner initDatabase(EmployeeRepository repository) {

		return args -> {
			Employee emp1 = new Employee("emp1", "t");
			log.info("Preloading " + repository.save(emp1));
		};
	}
} 