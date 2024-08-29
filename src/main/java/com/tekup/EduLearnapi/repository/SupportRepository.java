package com.tekup.EduLearnapi.repository;

import com.tekup.EduLearnapi.model.Support;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SupportRepository extends JpaRepository<Support, Long> {
    List<Support> findByChapitreTitre(String titre);

}
