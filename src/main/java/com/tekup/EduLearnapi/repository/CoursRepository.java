package com.tekup.EduLearnapi.repository;


import com.tekup.EduLearnapi.model.Cours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursRepository extends JpaRepository<Cours, Long> {
	
}
