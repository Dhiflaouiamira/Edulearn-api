package com.tekup.EduLearnapi.repository;


import com.tekup.EduLearnapi.model.Cours;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursRepository extends JpaRepository<Cours, Long> {
	List<Cours> findByTitre(String titre);
	List<Cours> findByDescription(String description);
    List<Cours> findByLangueNom(String nom);
    Set<Cours> findByAssignedCategorieId(Long categorieId);
    Set<Cours> findByAssignedUserId(Long userId);


}
