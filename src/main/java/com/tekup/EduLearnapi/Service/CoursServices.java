package com.tekup.EduLearnapi.Service;


import java.util.List;




import java.util.Optional;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.tekup.EduLearnapi.dto.ChapitreDTO;
import com.tekup.EduLearnapi.dto.CommentaireDTO;
import com.tekup.EduLearnapi.dto.CoursDTO;
import com.tekup.EduLearnapi.dto.LangueDTO;
import com.tekup.EduLearnapi.dto.PaiementDTO;
import com.tekup.EduLearnapi.model.Cours;
public interface CoursServices {

	public Page<CoursDTO> getAllCours(Pageable pageable) ;
	public void deleteOneCours(long id);
	public Optional<CoursDTO> findOneCours(long id);
	public Optional<CoursDTO> updateOneCours(Long id, CoursDTO coursDTO);
	public CoursDTO assignCommentaireToCours(long id,CommentaireDTO commentaire);
	public CoursDTO assignChapitreToCours(long id,ChapitreDTO chapitre);
	public CoursDTO assignPaiementToCours(long id, PaiementDTO paiementDTO)  ;
	public CoursDTO  assignCategorieToCours(Long coursId, Long categorieId);
	public List<Cours> findCoursesByLangue(String langue);
	public List<Cours> findCoursesByTitre(String titre);
	public List<Cours> findCoursesBydesc(String description);
	public LangueDTO addCourseAndAssign(CoursDTO coursDTO, long langueId, long userId);
	public Set<Cours> getCoursesByCategory(Long categorieId);
	public Set<Cours> getCoursesByUser(Long UserId);
	
	public CoursDTO  assignUserToCours(Long coursId, Long userId);
	public void requestMeeting(Long courseId);

	
	
	}
