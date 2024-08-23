package com.tekup.EduLearnapi.Service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.tekup.EduLearnapi.dto.ChapitreDTO;
import com.tekup.EduLearnapi.dto.SupportDTO;

public interface ChapitreServices {

	
	public Page<ChapitreDTO> getAllChapitres(Pageable pageable) ;
	public ChapitreDTO addOneChapitre(ChapitreDTO chapitre);
	public void deleteOneChapitre(long id);
	public Optional<ChapitreDTO> findOneChapitre(long id);
    public Optional<ChapitreDTO> updateOneChapitre(Long id, ChapitreDTO chapitreDTO) ;
	public ChapitreDTO assignSupportToChapitre(long id,SupportDTO support);

}
