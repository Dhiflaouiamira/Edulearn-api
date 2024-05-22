package com.tekup.EduLearnapi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.EduLearnapi.model.Categorie;
import com.tekup.EduLearnapi.repository.CategorieRepository;

@Service
public class CategorieServicesImpl implements CategorieServices {

	@Autowired
	CategorieRepository categorieRepository;
	
	@Override
	public List<Categorie> findAll() {
		return categorieRepository.findAll();
	}

	@Override
	public Categorie findOne(long id) {
		return categorieRepository.findById(id).orElse(null);

	}

	@Override
	public Categorie AddOne(Categorie categorie) {
		return categorieRepository.save(categorie);
	}

	@Override
	public void DeleteOne(long id) {
		categorieRepository.deleteById(id);
		
	}

}
