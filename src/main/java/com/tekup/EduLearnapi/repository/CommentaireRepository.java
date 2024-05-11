package com.tekup.EduLearnapi.repository;

import com.tekup.EduLearnapi.model.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
}
