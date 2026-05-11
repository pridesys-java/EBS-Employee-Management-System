package com.ebs.ems.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.ebs.ems.cicd.repo.PositionRepo;
import com.ebs.ems.entity.Position;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PositionService {

	private final PositionRepo repo;

	public void save(Position e) {
		repo.save(e);
	}

	public Optional<Position> findByPositionId(Integer id) {
		Optional<Position> position = repo.findById(id);
		return position;
	}

	public Optional<Position> findByPositionName(String posName) {
		Optional<Position> position = repo.findByPositionName(posName);
		return position;
	}

	public List<Position> getAllPositionData() {
		List<Position> list = repo.findAll();
		return list;
	}

	public void removePositionById(Integer posId) {
		repo.deleteById(posId);
	}

}
