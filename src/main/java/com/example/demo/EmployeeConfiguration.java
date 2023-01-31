package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jndi.JndiObjectFactoryBean;

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
	
	@Autowired
	private Environment env;

	@Bean
	public DataSource jndiDataSource() throws IllegalArgumentException, NamingException {
		JndiObjectFactoryBean bean = new JndiObjectFactoryBean();

		bean.setJndiName("java:comp/env/" + env.getProperty("spring.datasource.jndi-name"));
		bean.setLookupOnStartup(false);
		bean.setCache(true);
		bean.setProxyInterface(DataSource.class);
		bean.afterPropertiesSet();

		return (DataSource) bean.getObject();
	}
} 
