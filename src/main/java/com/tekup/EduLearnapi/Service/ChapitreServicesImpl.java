package com.tekup.EduLearnapi.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tekup.EduLearnapi.dto.ChapitreDTO;
import com.tekup.EduLearnapi.mappers.ChapitreMapper;
import com.tekup.EduLearnapi.model.Chapitre;
import com.tekup.EduLearnapi.repository.ChapitreRepository;

@Service
public class ChapitreServicesImpl implements ChapitreServices {

	@Autowired
	ChapitreRepository chapitreRepository;

	@Override
	public Page<ChapitreDTO> getAllChapitres(Pageable pageable) {
		Page<Chapitre> chapitres=chapitreRepository.findAll(pageable);
		return chapitres.map(ChapitreMapper::convertToDto);
		
	}


	@Override
	public ChapitreDTO addOneChapitre(ChapitreDTO chapitre) {
		return ChapitreMapper.convertToDto(chapitreRepository.save(ChapitreMapper.convertToEntity(chapitre)));

	}

	@Override
	public void deleteOneChapitre(long id) {
		chapitreRepository.deleteById(id);		
	}



	@Override
	public Optional<ChapitreDTO> findOneChapitre(long id) {
		return chapitreRepository.findById(id).map(ChapitreMapper::convertToDto);

	}
}
