package com.jenkins.cicd.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.jenkins.cicd.entity.Employee;
import com.jenkins.cicd.repo.EmployeeRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {

	private final EmployeeRepo empRepo;

	public void save(Employee e) {
		empRepo.save(e);
	}

	public Optional<Employee> findEmpByEmpId(Integer id) {
		Optional<Employee> emp = empRepo.findById(id);
		return emp;
	}

	public Optional<Employee> findEmpByEmpName(String empName) {
		Optional<Employee> emp = empRepo.findByEmpName(empName);
		return emp;
	}

	public List<Employee> getAllEmpData() {
		List<Employee> list = empRepo.findAll();
		return list;
	}

	public void removeEmpByEmpId(Integer empId) {
		empRepo.deleteById(empId);
	}

	public Map<String, Object> getStats() {

		Map<Object, Long> deptStats = empRepo.findAll().stream()
				.collect(Collectors.groupingBy(e -> e.getDepartment().getDepName(), Collectors.counting()));

		Map<Object, Long> posStats = empRepo.findAll().stream()
				.collect(Collectors.groupingBy(e -> e.getPosition().getPositionName(), Collectors.counting()));

		Map<String, Object> result = new HashMap<>();
		result.put("dept", deptStats);
		result.put("pos", posStats);

		return result;
	}

}
