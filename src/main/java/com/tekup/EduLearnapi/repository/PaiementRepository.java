package com.tekup.EduLearnapi.repository;

import com.tekup.EduLearnapi.model.Cours;
import com.tekup.EduLearnapi.model.Paiement;
import com.tekup.EduLearnapi.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {
    boolean existsByCoursAndUser(Cours cours, User user);
    @Query("SELECT p.cours.id FROM Paiement p WHERE p.user.id = :userId")
    List<Long> findCoursIdsByUserId(@Param("userId") Long userId);
}
