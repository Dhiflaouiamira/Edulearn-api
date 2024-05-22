package com.tekup.EduLearnapi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.EduLearnapi.model.Langue;
import com.tekup.EduLearnapi.repository.LangueRepository;

@Service
public class LangueServicesImpl implements LangueServices{

	@Autowired
	LangueRepository langueRepository;
	
	
	@Override
	public List<Langue> findAll() {
		return langueRepository.findAll();

	}

	@Override
	public Langue findOne(long id) {
		return langueRepository.findById(id).orElse(null);

	}

	@Override
	public Langue AddOne(Langue langue) {
		return langueRepository.save(langue);
	}

	@Override
	public void DeleteOne(long id) {
		langueRepository.deleteById(id);
		
	}

	@Override
	public List<Langue> findLangueByNom(String nom) {
		return langueRepository.findByNom( nom);
	}



	}

