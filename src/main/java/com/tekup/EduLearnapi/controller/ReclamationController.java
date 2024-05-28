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

import com.tekup.EduLearnapi.Service.ReclamationServices;
import com.tekup.EduLearnapi.dto.ReclamationDTO;

@RestController
@RequestMapping("/api/reclamations")
public class ReclamationController {

	 @Autowired
	    private ReclamationServices reclamationServices;

	 @GetMapping
	    public Page<ReclamationDTO> getReclamations(Pageable pageable)
	    {
	    	return reclamationServices.getAllReclamations(pageable);
	    }

	    @PostMapping
	    public ReclamationDTO addOneReclamation(@RequestBody ReclamationDTO reclamation)
	    {
	    return reclamationServices.addOneReclamation(reclamation);	
	    }

	    @DeleteMapping("/{id}")
	    public void deleteOneReclamation(@PathVariable long id)
	    {
	    reclamationServices.deleteOneReclamation(id);	

	    }

}

