package com.ebs.ems.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.ebs.ems.cicd.repo.DepartmentRepo;
import com.ebs.ems.entity.Department;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentService {

	private final DepartmentRepo departmentRepo;

	public void save(Department e) {
		departmentRepo.save(e);
	}

	public Optional<Department> findByDepartmentId(Integer id) {
		Optional<Department> department = departmentRepo.findById(id);
		return department;
	}

	public Optional<Department> findByDepartmentName(String depName) {
		Optional<Department> department = departmentRepo.findByDepName(depName);
		return department;
	}

	public List<Department> getAllDepartmentData() {
		List<Department> list = departmentRepo.findAll();
		return list;
	}
	
	public void removeDepartmentById(Integer depId) {
		departmentRepo.deleteById(depId);
	}

}
