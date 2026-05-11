package com.jenkins.cicd.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jenkins.cicd.entity.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {

	Optional<Department> findByDepName(String depName);

}
