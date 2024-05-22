package com.tekup.EduLearnapi.repository;

import com.tekup.EduLearnapi.model.Langue;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LangueRepository extends JpaRepository<Langue, Long> {
	List<Langue> findByNom(String nom);
}
