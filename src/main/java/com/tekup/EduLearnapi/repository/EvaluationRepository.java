package com.tekup.EduLearnapi.repository;

import com.tekup.EduLearnapi.model.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
    List<Evaluation> findByTitre(String titre);
}
