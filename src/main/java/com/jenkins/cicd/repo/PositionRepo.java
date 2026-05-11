package com.jenkins.cicd.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jenkins.cicd.entity.Position;

@Repository
public interface PositionRepo extends JpaRepository<Position, Integer> {

	Optional<Position> findByPositionName(String positionName);

}
