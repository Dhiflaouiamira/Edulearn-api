package com.tekup.EduLearnapi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.EduLearnapi.model.Cours;
import com.tekup.EduLearnapi.repository.CoursRepository;

@Service

public class CoursServicesImpl implements CoursServices{

	@Autowired
	CoursRepository coursRepository;
	
	
	@Override
	public List<Cours> findAll() {
		return coursRepository.findAll();

	}

	@Override
	public Cours findOne(long id) {
		return coursRepository.findById(id).orElse(null);

	}

	@Override
	public Cours AddOne(Cours cours) {
		return coursRepository.save(cours);
	}

	@Override
	public void DeleteOne(long id) {
		coursRepository.deleteById(id);
		
	}

	@Override
	public List<Cours> findCoursesByTitre(String titre) {
		return coursRepository.findByTitre( titre);
	}

	@Override
	public List<Cours> findCoursesBydesc(String description) {
		return coursRepository.findByDescriptionContains( description);
	}


	}

