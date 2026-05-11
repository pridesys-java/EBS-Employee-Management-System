package com.jenkins.cicd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jenkins.cicd.entity.Employee;
import com.jenkins.cicd.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employee")
public class EmployeeController {

	private final EmployeeService service;

	@PostMapping("save")
	public Optional<Employee> saveData(@RequestBody Employee entity) {
		service.save(entity);
		Optional<Employee> emp = findEmpByEmpId(entity.getId());
		return emp;
	}

	@GetMapping("get-by-id/{emp_id}")
	public Optional<Employee> findEmpByEmpId(@PathVariable("emp_id") Integer empId) {
		Optional<Employee> emp = service.findEmpByEmpId(empId);
		return emp;
	}

	@GetMapping("get-by-name/{empName}")
	public Optional<Employee> findEmpByEmpName(@PathVariable String empName) {
		Optional<Employee> emp = service.findEmpByEmpName(empName);
		return emp;
	}

	@GetMapping("get-all")
	public List<Employee> getAllEmpData() {
		List<Employee> list = service.getAllEmpData();
		return list;
	}

	@DeleteMapping("remove-by-id/{emp_id}")
	public void removeEmpBy(@PathVariable("emp_id") Integer id) {
		service.removeEmpByEmpId(id);
	}

	@GetMapping("/stats")
	public Map<String, Object> getStats() {
		Map<String, Object> result = service.getStats();
		return result;
	}

}
