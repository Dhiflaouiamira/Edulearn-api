package com.tekup.EduLearnapi.Service;


import java.util.List;



import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tekup.EduLearnapi.dto.CategorieDTO;
import com.tekup.EduLearnapi.dto.ChapitreDTO;
import com.tekup.EduLearnapi.dto.CommentaireDTO;
import com.tekup.EduLearnapi.dto.CoursDTO;
import com.tekup.EduLearnapi.dto.PaiementDTO;
import com.tekup.EduLearnapi.model.Cours;
public interface CoursServices {

	public Page<CoursDTO> getAllCours(Pageable pageable) ;
	public CoursDTO addOneCours(CoursDTO cours);
	public void deleteOneCours(long id);
	public Optional<CoursDTO> findOneCours(long id);
	public List<Cours> findCoursesByTitre(String titre);
	public List<Cours> findCoursesBydesc(String description);
	public CoursDTO assignCommentaireToCours(long id,CommentaireDTO commentaire);
	public CoursDTO assignChapitreToCours(long id,ChapitreDTO chapitre);
	public CoursDTO assignPaiementToCours(long id,PaiementDTO paiementDTO);
	public CoursDTO assignCategorieToCours(long id,CategorieDTO categorie);

	
}
