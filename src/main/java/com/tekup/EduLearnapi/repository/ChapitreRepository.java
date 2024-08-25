package com.tekup.EduLearnapi.repository;

import com.tekup.EduLearnapi.model.Chapitre;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChapitreRepository extends JpaRepository<Chapitre, Long> {
    List<Chapitre> findByCoursTitre(String titre);

}
