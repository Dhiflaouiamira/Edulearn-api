package com.tekup.EduLearnapi.repository;

import com.tekup.EduLearnapi.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	

		List<User> findByNomOrPrenom(String nom,String prenom);
	}

