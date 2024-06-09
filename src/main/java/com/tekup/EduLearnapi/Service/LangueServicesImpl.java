package com.tekup.EduLearnapi.Service;

import java.util.List;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tekup.EduLearnapi.dto.CoursDTO;
import com.tekup.EduLearnapi.dto.LangueDTO;
import com.tekup.EduLearnapi.mappers.CoursMapper;
import com.tekup.EduLearnapi.mappers.LangueMapper;
import com.tekup.EduLearnapi.model.Cours;
import com.tekup.EduLearnapi.model.Langue;
import com.tekup.EduLearnapi.repository.CoursRepository;
import com.tekup.EduLearnapi.repository.LangueRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class LangueServicesImpl implements LangueServices{

	private final LangueRepository langueRepository;
	
	private final CoursRepository coursRepository;
	
	
	@Override
	public Page<LangueDTO> getAllLangues(Pageable pageable) {
		Page<Langue> langues=langueRepository.findAll(pageable);
		return langues.map(LangueMapper::convertToDto);
		
	}


	@Override
	public LangueDTO addOneLangue(LangueDTO langue) {
		return LangueMapper.convertToDto(langueRepository.save(LangueMapper.convertToEntity(langue)));

	}

	@Override
	public void deleteOneLangue(long id) {
		langueRepository.deleteById(id);		
	}



	@Override
	public Optional<LangueDTO> findOneLangue(long id) {
		return langueRepository.findById(id).map(LangueMapper::convertToDto);

	}

	@Override
	public List<Langue> findLangueByNom(String nom) {
		return langueRepository.findByNom( nom);
	}


	@Override
	public LangueDTO assignCoursToLangue(long id, CoursDTO coursDTO) {
	    Langue langue = langueRepository.findById(id).orElse(null);
	    if (langue != null) {
	        Cours cours = CoursMapper.convertToEntity(coursDTO); 
	        cours.setLangue(langue);
	        coursRepository.save(cours);
	        return LangueMapper.convertToDto(langue);
	    }
	    
	    return null;
	}

	


	}

