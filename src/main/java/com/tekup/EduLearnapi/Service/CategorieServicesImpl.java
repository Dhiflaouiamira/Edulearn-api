package com.tekup.EduLearnapi.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.tekup.EduLearnapi.dto.CategorieDTO;
import com.tekup.EduLearnapi.mappers.CategorieMapper;
import com.tekup.EduLearnapi.model.Categorie;
import com.tekup.EduLearnapi.repository.CategorieRepository;

@Service
public class CategorieServicesImpl implements CategorieServices {

	@Autowired
	CategorieRepository categorieRepository;

	@Override
	public Page<CategorieDTO> getAllCategories(Pageable pageable) {
		Page<Categorie> categories=categorieRepository.findAll(pageable);
		return categories.map(CategorieMapper::convertToDto);
		
	}


	@Override
	public CategorieDTO addOneCategorie(CategorieDTO categorie) {
		return CategorieMapper.convertToDto(categorieRepository.save(CategorieMapper.convertToEntity(categorie)));

	}

	@Override
	public void deleteOneCategorie(long id) {
		categorieRepository.deleteById(id);		
	}



	@Override
	public Optional<CategorieDTO> findOneCategorie(long id) {
		return categorieRepository.findById(id).map(CategorieMapper::convertToDto);

	}

}
