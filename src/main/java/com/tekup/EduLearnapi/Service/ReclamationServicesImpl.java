package com.tekup.EduLearnapi.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tekup.EduLearnapi.model.Reclamation;
import com.tekup.EduLearnapi.repository.ReclamationRepository;

@Service
public class ReclamationServicesImpl implements ReclamationServices {

	
	ReclamationRepository reclamationRepository;

	@Override
	public List<Reclamation> findAll() {
		return reclamationRepository.findAll();

	}

	@Override
	public Reclamation findOne(long id) {
		return reclamationRepository.findById(id).orElse(null);

	}

	@Override
	public Reclamation AddOne(Reclamation reclamation) {
		return reclamationRepository.save(reclamation);

	}

	@Override
	public void DeleteOne(long id) {
		reclamationRepository.deleteById(id);
		
	}

}
