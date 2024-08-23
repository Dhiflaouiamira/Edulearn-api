package com.tekup.EduLearnapi.repository;

import com.tekup.EduLearnapi.model.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
public interface UserRepository extends JpaRepository<User, Long> {
	

	    Optional<User> findByEmail(String email);
	    Optional<User> findByNom(String userName);
	    Page<User> findByRole(String role, Pageable pageable);


	}

