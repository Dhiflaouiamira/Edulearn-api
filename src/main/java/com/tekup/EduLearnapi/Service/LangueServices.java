package com.tekup.EduLearnapi.Service;

import java.util.List;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tekup.EduLearnapi.dto.CoursDTO;
import com.tekup.EduLearnapi.dto.LangueDTO;
import com.tekup.EduLearnapi.model.Langue;

public interface LangueServices {

	public Page<LangueDTO> getAllLangues(Pageable pageable) ;
	public LangueDTO addOneLangue(LangueDTO langue);
	public void deleteOneLangue(long id);
	public Optional<LangueDTO> findOneLangue(long id);
	public List<Langue> findLangueByNom(String nom);
	public LangueDTO assignCoursToLangue(long id,CoursDTO cours);

}
