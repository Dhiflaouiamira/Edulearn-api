package com.tekup.EduLearnapi.repository;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tekup.EduLearnapi.model.Question;
@Repository
public interface QuestionRepository  extends JpaRepository<Question, Long>{

    @Query("SELECT DISTINCT q.chapitre.id FROM Question q")
    List<String> findDistinctSubject();
    Page<Question> findByChapitre_Id(Long chapitreId, Pageable pageable);

}
