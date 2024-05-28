package com.tekup.EduLearnapi.Service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tekup.EduLearnapi.dto.ReunionDTO;

public interface ReunionServices {

	public Page<ReunionDTO> getAllReunions(Pageable pageable) ;
	public ReunionDTO addOneReunion(ReunionDTO reunion);
	public void deleteOneReunion(long id);
	public Optional<ReunionDTO> findOneReunion(long id);
}
