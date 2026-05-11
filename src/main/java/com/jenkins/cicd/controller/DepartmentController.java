package com.jenkins.cicd.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jenkins.cicd.entity.Department;
import com.jenkins.cicd.service.DepartmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/department")
public class DepartmentController {

	private final DepartmentService service;

	@PostMapping("save")
	public Optional<Department> saveData(@RequestBody Department entity) {
		service.save(entity);
		Optional<Department> emp = findDepartmentById(entity.getId());
		return emp;
	}

	@GetMapping("get-by-id/{depId}")
	public Optional<Department> findDepartmentById(@PathVariable Integer depId) {
		Optional<Department> emp = service.findByDepartmentId(depId);
		return emp;
	}

	@GetMapping("get-by-name/{depName}")
	public Optional<Department> getDepartmentByName(@PathVariable String depName) {
		Optional<Department> emp = service.findByDepartmentName(depName);
		return emp;
	}

	@GetMapping("get-all")
	public List<Department> getAllDepartment() {
		List<Department> list = service.getAllDepartmentData();
		return list;
	}
	
	@GetMapping("remove-by-id/{dep_id}")
	public void removeDepartment(@PathVariable("dep_id") Integer id) {
		service.removeDepartmentById(id);
	}
}
