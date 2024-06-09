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

import com.tekup.EduLearnapi.Service.CategorieServices;
import com.tekup.EduLearnapi.dto.CategorieDTO;



@RestController
@RequestMapping("/api/categories")
public class CategorieController {

	 @Autowired
	    private CategorieServices categorieServices;

	 @GetMapping
	    public Page<CategorieDTO> getCategories(Pageable pageable)
	    {
	    	return categorieServices.getAllCategories(pageable);
	    }

	    @PostMapping
	    public CategorieDTO addOneCategorie(@RequestBody CategorieDTO categorie)
	    {
	    return categorieServices.addOneCategorie(categorie);	
	    }

	    @DeleteMapping("/{id}")
	    public void deleteOneCategorie(@PathVariable long id)
	    {
	    categorieServices.deleteOneCategorie(id);	

	    }

}
