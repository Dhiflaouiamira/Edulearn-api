package com.tekup.EduLearnapi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.EduLearnapi.model.Chapitre;
import com.tekup.EduLearnapi.repository.ChapitreRepository;

@Service
public class ChapitreServicesImpl implements ChapitreServices {

	@Autowired
	ChapitreRepository chapitreRepository;
	
	@Override
	public List<Chapitre> findAll() {
		return chapitreRepository.findAll();
	}

	@Override
	public Chapitre findOne(long id) {
		return chapitreRepository.findById(id).orElse(null);

	}

	@Override
	public Chapitre AddOne(Chapitre chapitre) {
		return chapitreRepository.save(chapitre);
	}

	@Override
	public void DeleteOne(long id) {
		chapitreRepository.deleteById(id);
		
	}

}
