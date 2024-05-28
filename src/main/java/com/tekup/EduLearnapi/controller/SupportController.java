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

import com.tekup.EduLearnapi.Service.SupportServices;
import com.tekup.EduLearnapi.dto.SupportDTO;

@RestController
@RequestMapping("/api/supports")
public class SupportController {

	 @Autowired
	    private SupportServices supportServices;

	 @GetMapping
	    public Page<SupportDTO> getSupports(Pageable pageable)
	    {
	    	return supportServices.getAllSupports(pageable);
	    }

	    @PostMapping
	    public SupportDTO addOneSupport(@RequestBody SupportDTO support)
	    {
	    return supportServices.addOneSupport(support);	
	    }

	    @DeleteMapping("/{id}")
	    public void deleteOneSupport(@PathVariable long id)
	    {
	    supportServices.deleteOneSupport(id);	

	    }

}

