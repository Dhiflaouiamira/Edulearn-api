package com.tekup.EduLearnapi.Service;

import java.util.List;


import java.util.Optional;
import java.util.Set;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.tekup.EduLearnapi.dto.CategorieDTO;
import com.tekup.EduLearnapi.dto.ChapitreDTO;
import com.tekup.EduLearnapi.dto.CommentaireDTO;
import com.tekup.EduLearnapi.dto.CoursDTO;
import com.tekup.EduLearnapi.dto.PaiementDTO;
import com.tekup.EduLearnapi.mappers.CategorieMapper;
import com.tekup.EduLearnapi.mappers.ChapitreMapper;
import com.tekup.EduLearnapi.mappers.CommentaireMapper;
import com.tekup.EduLearnapi.mappers.CoursMapper;
import com.tekup.EduLearnapi.mappers.PaiementMapper;
import com.tekup.EduLearnapi.model.Categorie;
import com.tekup.EduLearnapi.model.Chapitre;
import com.tekup.EduLearnapi.model.Commentaire;
import com.tekup.EduLearnapi.model.Cours;
import com.tekup.EduLearnapi.repository.ChapitreRepository;
import com.tekup.EduLearnapi.repository.CommentaireRepository;
import com.tekup.EduLearnapi.repository.CoursRepository;


import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class CoursServicesImpl implements CoursServices{

	private final CoursRepository coursRepository;
	private final CommentaireRepository commentaireRepository;
	private final ChapitreRepository chapitreRepository;

	@Override
	public Page<CoursDTO> getAllCours(Pageable pageable) {
		Page<Cours> courss=coursRepository.findAll(pageable);
		return courss.map(CoursMapper::convertToDto);
		
	}


	@Override
	public CoursDTO addOneCours(CoursDTO cours) {
		return CoursMapper.convertToDto(coursRepository.save(CoursMapper.convertToEntity(cours)));

	}

	@Override
	public void deleteOneCours(long id) {
		coursRepository.deleteById(id);		
	}



	@Override
	public Optional<CoursDTO> findOneCours(long id) {
		return coursRepository.findById(id).map(CoursMapper::convertToDto);

	}


	@Override
	public List<Cours> findCoursesByTitre(String titre) {
		return coursRepository.findByTitre( titre);
	}

	@Override
	public List<Cours> findCoursesBydesc(String description) {
		return coursRepository.findByDescriptionContains( description);
	}
	
	@Override
	public CoursDTO assignCommentaireToCours(long id, CommentaireDTO commentaire) {
		Cours cours=coursRepository.findById(id).orElse(null);
		if(cours!=null)
		{
			Commentaire cmt=CommentaireMapper.convertToEntity(commentaire);
			cmt.setCours(cours);
			commentaireRepository.save(cmt);
			return CoursMapper.convertToDto(cours);
		}
		
		return null;
	}
	
	
	
	@Override
	public CoursDTO assignChapitreToCours(long id, ChapitreDTO chapitre) {
		Cours cours=coursRepository.findById(id).orElse(null);
		if(cours!=null)
		{
			Chapitre cha=ChapitreMapper.convertToEntity(chapitre);

			cha.setCours(cours);
			chapitreRepository.save(cha);
			return CoursMapper.convertToDto(cours);
		}
		
		return null;
	}
	
	@Override
	public CoursDTO assignPaiementToCours(long id, PaiementDTO paiement) {
		Cours cours=coursRepository.findById(id).orElse(null);
		if(cours!=null)
		{
			cours.setPaiement(PaiementMapper.convertToEntity(paiement));
			return CoursMapper.convertToDto(coursRepository.save(cours));
		}
		return null;
	}


	@Override
	public CoursDTO assignCategorieToCours(long id, CategorieDTO categorie) {
		Cours cours=coursRepository.findById(id).orElse(null);
		if(cours!=null)
		{
			Set<Categorie> categories=cours.getCategories();
			categories.add(CategorieMapper.convertToEntity(categorie));
			return CoursMapper.convertToDto(coursRepository.save(cours));
		}
		
		return null;
	}	
	}

