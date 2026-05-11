package com.ebs.ems.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.ebs.ems.cicd.repo.LoginUserRepo;
import com.ebs.ems.entity.Employee;
import com.ebs.ems.entity.LoginUser;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {

	private final LoginUserRepo repo;

	public void save(LoginUser e) {
		repo.save(e);
	}

	public Optional<LoginUser> findByDepartmentId(Integer id) {
		Optional<LoginUser> loginUser = repo.findById(id);
		return loginUser;
	}

	public Optional<LoginUser> findByEmail(String empName) {
		Optional<LoginUser> loginUser = repo.findByEmail(empName);
		return loginUser;
	}

	public List<LoginUser> getAllLoginUser() {
		List<LoginUser> list = repo.findAll();
		return list;
	}
	
	public void removeLoginUserById(Integer loginUserId) {
		repo.deleteById(loginUserId);
	}
}
