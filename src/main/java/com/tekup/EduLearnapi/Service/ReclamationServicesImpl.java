package com.tekup.EduLearnapi.Service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tekup.EduLearnapi.dto.ReclamationDTO;
import com.tekup.EduLearnapi.mappers.ReclamationMapper;
import com.tekup.EduLearnapi.model.Reclamation;
import com.tekup.EduLearnapi.repository.ReclamationRepository;

@Service
public class ReclamationServicesImpl implements ReclamationServices {

	
	ReclamationRepository reclamationRepository;

	@Override
	public Page<ReclamationDTO> getAllReclamations(Pageable pageable) {
		Page<Reclamation> reclamations=reclamationRepository.findAll(pageable);
		return reclamations.map(ReclamationMapper::convertToDto);
		
	}


	@Override
	public ReclamationDTO addOneReclamation(ReclamationDTO reclamation) {
		return ReclamationMapper.convertToDto(reclamationRepository.save(ReclamationMapper.convertToEntity(reclamation)));

	}

	@Override
	public void deleteOneReclamation(long id) {
		reclamationRepository.deleteById(id);		
	}



	@Override
	public Optional<ReclamationDTO> findOneReclamation(long id) {
		return reclamationRepository.findById(id).map(ReclamationMapper::convertToDto);

	}

}
