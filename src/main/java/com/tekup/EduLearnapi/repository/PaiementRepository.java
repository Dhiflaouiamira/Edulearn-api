package com.tekup.EduLearnapi.repository;

import com.tekup.EduLearnapi.model.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {
}
