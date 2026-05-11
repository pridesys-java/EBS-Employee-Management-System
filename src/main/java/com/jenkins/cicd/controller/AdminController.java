package com.jenkins.cicd.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jenkins.cicd.entity.Department;
import com.jenkins.cicd.service.DepartmentService;
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
