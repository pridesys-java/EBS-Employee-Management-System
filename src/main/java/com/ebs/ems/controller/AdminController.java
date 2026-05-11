package com.ebs.ems.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebs.ems.entity.Department;
import com.ebs.ems.service.DepartmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {

	private final DepartmentService service;

	@GetMapping("/home")
	public List<Department> home() {
		List<Department> list = service.getAllDepartmentData();
		return list;
	}
}
