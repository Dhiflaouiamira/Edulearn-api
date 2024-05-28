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

import com.tekup.EduLearnapi.Service.ChapitreServices;
import com.tekup.EduLearnapi.dto.ChapitreDTO;



@RestController
@RequestMapping("/api/chapitres")
public class ChapitreController {

	 @Autowired
	    private ChapitreServices chapitreServices;

	 @GetMapping
	    public Page<ChapitreDTO> getChapitres(Pageable pageable)
	    {
	    	return chapitreServices.getAllChapitres(pageable);
	    }

	    @PostMapping
	    public ChapitreDTO addOneChapitre(@RequestBody ChapitreDTO chapitre)
	    {
	    return chapitreServices.addOneChapitre(chapitre);	
	    }

	    @DeleteMapping("/{id}")
	    public void deleteOneChapitre(@PathVariable long id)
	    {
	    chapitreServices.deleteOneChapitre(id);	

	    }

}
