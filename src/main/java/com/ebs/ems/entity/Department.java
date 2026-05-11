package com.ebs.ems.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "DEPARTMENT")
@Data
public class Department {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "DEP_NAME")
	private String depName;

	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
//	@JsonManagedReference(value = "dep-emp")
	private List<Employee> employeeList = new ArrayList<>();

}
