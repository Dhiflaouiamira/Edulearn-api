package com.tekup.EduLearnapi.Service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tekup.EduLearnapi.dto.ReclamationDTO;

public interface ReclamationServices {

	public Page<ReclamationDTO> getAllReclamations(Pageable pageable) ;
	public ReclamationDTO addOneReclamation(ReclamationDTO reclamation);
	public void deleteOneReclamation(long id);
	public Optional<ReclamationDTO> findOneReclamation(long id);
}
