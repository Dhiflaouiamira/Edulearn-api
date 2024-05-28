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

import com.tekup.EduLearnapi.Service.ReunionServices;
import com.tekup.EduLearnapi.dto.ReunionDTO;

@RestController
@RequestMapping("/api/reunions")
public class ReunionController {

	 @Autowired
	    private ReunionServices reunionServices;

	 @GetMapping
	    public Page<ReunionDTO> getReunions(Pageable pageable)
	    {
	    	return reunionServices.getAllReunions(pageable);
	    }

	    @PostMapping
	    public ReunionDTO addOneReunion(@RequestBody ReunionDTO reunion)
	    {
	    return reunionServices.addOneReunion(reunion);	
	    }

	    @DeleteMapping("/{id}")
	    public void deleteOneReunion(@PathVariable long id)
	    {
	    reunionServices.deleteOneReunion(id);	

	    }

}

