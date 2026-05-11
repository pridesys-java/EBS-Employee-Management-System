package com.jenkins.cicd.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jenkins.cicd.entity.LoginUser;

@Repository
public interface LoginUserRepo extends JpaRepository<LoginUser, Integer> {

	Optional<LoginUser> findByEmail(String email);

}
