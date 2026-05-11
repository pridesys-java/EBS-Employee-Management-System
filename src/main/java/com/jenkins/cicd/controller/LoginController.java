package com.jenkins.cicd.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jenkins.cicd.entity.LoginUser;
import com.jenkins.cicd.service.LoginService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/login")
public class LoginController {

	private final LoginService service;

	@PostMapping("/do-login")
	public boolean login(@RequestParam("EMAIL") String email, @RequestParam("PASSWORD") String password) {
		Optional<LoginUser> loginUser = getLoginUserByEmail(email);
		if (loginUser.isPresent() && password.equalsIgnoreCase(loginUser.get().getPassword())) {
			return true;
		} else {
			return false;
		}
	}

	@PostMapping("save")
	public Optional<LoginUser> save(@RequestBody LoginUser entity) {
		service.save(entity);
		Optional<LoginUser> loginUser = getLoginUserByEmail(entity.getEmail());
		return loginUser;
	}

	@GetMapping("get-by-email/{email}")
	public Optional<LoginUser> getLoginUserByEmail(@PathVariable String email) {
		Optional<LoginUser> emp = service.findByEmail(email);
		return emp;
	}

	@GetMapping("get-all")
	public List<LoginUser> getAll() {
		List<LoginUser> list = service.getAllLoginUser();
		return list;
	}

	@GetMapping("remove-by-id/{id}")
	public void removeLoginUser(@PathVariable("id") Integer id) {
		service.removeLoginUserById(id);
	}
}
