package com.ebs.ems.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "EMPLOYEE")
@Data
public class Employee {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "EMP_NAME")
	private String empName;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "DOB")
	private Date dob;

	@Column(name = "JOINING_DATE")
	private Date joiningDate;

	@ManyToOne
	@JoinColumn(name = "department_id")
//	@JsonBackReference(value = "dep-emp")
	@JsonIgnoreProperties("employeeList")
	private Department department;

	@ManyToOne
	@JoinColumn(name = "position_id")
//	@JsonBackReference(value = "pos-emp")
	@JsonIgnoreProperties("employeeList")
	private Position position;
}
