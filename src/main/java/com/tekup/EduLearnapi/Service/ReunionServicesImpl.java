package com.tekup.EduLearnapi.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tekup.EduLearnapi.dto.ReunionDTO;
import com.tekup.EduLearnapi.mappers.ReunionMapper;
import com.tekup.EduLearnapi.model.Reunion;
import com.tekup.EduLearnapi.repository.ReunionRepository;

@Service
public class ReunionServicesImpl implements ReunionServices {

	@Autowired
	ReunionRepository reunionRepository;

	@Override
	public Page<ReunionDTO> getAllReunions(Pageable pageable) {
		Page<Reunion> reunions=reunionRepository.findAll(pageable);
		return reunions.map(ReunionMapper::convertToDto);
		
	}


	@Override
	public ReunionDTO addOneReunion(ReunionDTO reunion) {
		return ReunionMapper.convertToDto(reunionRepository.save(ReunionMapper.convertToEntity(reunion)));

	}

	@Override
	public void deleteOneReunion(long id) {
		reunionRepository.deleteById(id);		
	}



	@Override
	public Optional<ReunionDTO> findOneReunion(long id) {
		return reunionRepository.findById(id).map(ReunionMapper::convertToDto);

	}

}
