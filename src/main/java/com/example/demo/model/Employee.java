package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
@Builder
public class Employee {

	@Id
	@SequenceGenerator( //this annotation creates a sequence in database
			name = "employee_sequence",
			sequenceName = "employee_sequence",
			allocationSize = 1
			)

	@GeneratedValue(
			strategy=GenerationType.IDENTITY,
			generator="employee_sequence" //this is optional and should match a sequence name in db if used
			)
	private Long id;

	private @Column(name="name")
	String name;

	@Column(name="role")
	private String role;

	public Employee(String name, String role) {
		this.name = name;
		this.role = role;
	}
}
