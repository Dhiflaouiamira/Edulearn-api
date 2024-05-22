package com.tekup.EduLearnapi.repository;


import com.tekup.EduLearnapi.model.Cours;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursRepository extends JpaRepository<Cours, Long> {
	List<Cours> findByTitre(String titre);
	List<Cours> findByDescriptionContains(String description);
}
