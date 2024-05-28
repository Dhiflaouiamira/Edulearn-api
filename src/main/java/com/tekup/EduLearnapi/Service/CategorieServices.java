package com.tekup.EduLearnapi.Service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.tekup.EduLearnapi.dto.CategorieDTO;

public interface CategorieServices {

	public Page<CategorieDTO> getAllCategories(Pageable pageable) ;
	public CategorieDTO addOneCategorie(CategorieDTO categorie);
	public void deleteOneCategorie(long id);
	public Optional<CategorieDTO> findOneCategorie(long id);
}
