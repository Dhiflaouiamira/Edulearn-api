package com.tekup.EduLearnapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tekup.EduLearnapi.Service.PaiementServices;
import com.tekup.EduLearnapi.dto.PaiementDTO;

@RestController
@RequestMapping("/api/paiements")
public class PaiementController {

	 @Autowired
	    private PaiementServices paiementServices;

	 @GetMapping
	    public Page<PaiementDTO> getPaiements(Pageable pageable)
	    {
	    	return paiementServices.getAllPaiements(pageable);
	    }

	    @PostMapping
	    public PaiementDTO addOnePaiement(@RequestBody PaiementDTO paiement)
	    {
	    return paiementServices.addOnePaiement(paiement);	
	    }

	    @DeleteMapping("/{id}")
	    public void deleteOnePaiement(@PathVariable long id)
	    {
	    paiementServices.deleteOnePaiement(id);	

	    }

}

