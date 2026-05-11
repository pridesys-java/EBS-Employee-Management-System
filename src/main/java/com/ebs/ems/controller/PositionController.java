package com.ebs.ems.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebs.ems.entity.Position;
import com.ebs.ems.service.PositionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/position")
public class PositionController {

	private final PositionService service;

	@PostMapping("save")
	public Optional<Position> save(@RequestBody Position position) {
		service.save(position);
		Optional<Position> emp = getPositionById(position.getId());
		return emp;
	}

	@GetMapping("get-by-id/{depId}")
	public Optional<Position> getPositionById(@PathVariable Integer depId) {
		Optional<Position> emp = service.findByPositionId(depId);
		return emp;
	}

	@GetMapping("get-by-name/{depName}")
	public Optional<Position> getPositionByName(@PathVariable String depName) {
		Optional<Position> emp = service.findByPositionName(depName);
		return emp;
	}

	@GetMapping("get-all")
	public List<Position> getAll() {
		List<Position> list = service.getAllPositionData();
		return list;
	}
	
	@GetMapping("remove-by-id/{pos_id}")
	public void removePosition(@PathVariable("pos_id") Integer id) {
		service.removePositionById(id);
	}
}
