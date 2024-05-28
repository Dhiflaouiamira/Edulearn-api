package com.tekup.EduLearnapi.Service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tekup.EduLearnapi.dto.SupportDTO;

public interface SupportServices {

	public Page<SupportDTO> getAllSupports(Pageable pageable) ;
	public SupportDTO addOneSupport(SupportDTO support);
	public void deleteOneSupport(long id);
	public Optional<SupportDTO> findOneSupport(long id);
}
