package com.tekup.EduLearnapi.repository;

import com.tekup.EduLearnapi.model.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	

	    Optional<User> findByEmail(String email);
	    Optional<User> findByNom(String nom); // 

	}

