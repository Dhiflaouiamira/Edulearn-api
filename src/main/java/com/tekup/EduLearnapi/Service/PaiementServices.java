package com.tekup.EduLearnapi.Service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.tekup.EduLearnapi.dto.PaiementDTO;


public interface PaiementServices {

	public Page<PaiementDTO> getAllPaiements(Pageable pageable) ;
	public PaiementDTO addOnePaiement(PaiementDTO paiement);
	public void deleteOnePaiement(long id);
	public Optional<PaiementDTO> findOnePaiement(long id);


}
