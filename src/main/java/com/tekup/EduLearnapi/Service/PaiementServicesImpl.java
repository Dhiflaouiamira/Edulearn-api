package com.tekup.EduLearnapi.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tekup.EduLearnapi.dto.PaiementDTO;
import com.tekup.EduLearnapi.mappers.PaiementMapper;
import com.tekup.EduLearnapi.model.Paiement;
import com.tekup.EduLearnapi.repository.PaiementRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class PaiementServicesImpl implements PaiementServices{
	@Autowired
	private final PaiementRepository paiementRepository;
	
	
	
	@Override
	public Page<PaiementDTO> getAllPaiements(Pageable pageable) {
		Page<Paiement> paiements=paiementRepository.findAll(pageable);
		return paiements.map(PaiementMapper::convertToDto);
		
	}


	@Override
	public PaiementDTO addOnePaiement(PaiementDTO paiement) {
		return PaiementMapper.convertToDto(paiementRepository.save(PaiementMapper.convertToEntity(paiement)));

	}

	@Override
	public void deleteOnePaiement(long id) {
		paiementRepository.deleteById(id);		
	}



	@Override
	public Optional<PaiementDTO> findOnePaiement(long id) {
		return paiementRepository.findById(id).map(PaiementMapper::convertToDto);

	}




	}

