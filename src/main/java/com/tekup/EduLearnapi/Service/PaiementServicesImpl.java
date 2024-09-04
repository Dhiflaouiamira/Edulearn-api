package com.tekup.EduLearnapi.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tekup.EduLearnapi.dto.PaiementDTO;
import com.tekup.EduLearnapi.mappers.PaiementMapper;
import com.tekup.EduLearnapi.model.Cours;
import com.tekup.EduLearnapi.model.Paiement;
import com.tekup.EduLearnapi.model.User;
import com.tekup.EduLearnapi.repository.CoursRepository;
import com.tekup.EduLearnapi.repository.PaiementRepository;
import com.tekup.EduLearnapi.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class PaiementServicesImpl implements PaiementServices{
	@Autowired
	private final PaiementRepository paiementRepository;
	
	 @Autowired
	    private final UserRepository userRepository;

	 @Autowired
	    private final CoursRepository coursRepository;

	@Override
	public Page<PaiementDTO> getAllPaiements(Pageable pageable) {
		Page<Paiement> paiements=paiementRepository.findAll(pageable);
		return paiements.map(PaiementMapper::convertToDto);
		
	}

	@Override
	@Transactional
	public PaiementDTO createPaiement(PaiementDTO paiementDTO) {
	    // Fetch the Cours and User entities
	    Cours cours = coursRepository.findById(paiementDTO.getCoursId())
	                                .orElseThrow(() -> new RuntimeException("Course not found"));
	    User user = userRepository.findById(paiementDTO.getUserId())
	                              .orElseThrow(() -> new RuntimeException("User not found"));

	    // Convert PaiementDTO to Paiement entity
	    Paiement paiement = PaiementMapper.convertToEntity(paiementDTO);
	    paiement.setCours(cours);
	    paiement.setUser(user);

	    // Save the Paiement entity
	    Paiement savedPaiement = paiementRepository.save(paiement);

	    // Ensure the user is associated with the course
	    if (!cours.getAssignedUser().contains(user)) {
	        cours.getAssignedUser().add(user);
	        coursRepository.save(cours);
	    }

	    // Convert and return the PaiementDTO
	    return PaiementMapper.convertToDto(savedPaiement);
	}
	
	
	@Override
	public void deleteOnePaiement(long id) {
		paiementRepository.deleteById(id);		
	}



	@Override
	public Optional<PaiementDTO> findOnePaiement(long id) {
		return paiementRepository.findById(id).map(PaiementMapper::convertToDto);

	}


	@Override
	 public Optional<PaiementDTO> updateOnePaiement(Long id, PaiementDTO paiementDTO) {
        return paiementRepository.findById(id).map(paiement -> {
            paiement.setMontant(paiementDTO.getMontant());
            paiement.setDatePaiement(paiementDTO.getDatePaiement());
            paiement.setModePaiement(paiementDTO.getModePaiement());
            paiementRepository.save(paiement);

            return new PaiementDTO();
        });
    }


	}

