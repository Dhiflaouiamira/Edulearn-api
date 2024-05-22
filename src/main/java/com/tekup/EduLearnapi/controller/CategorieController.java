package com.tekup.EduLearnapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tekup.EduLearnapi.Service.CategorieServices;
import com.tekup.EduLearnapi.model.Categorie;



@RestController
@RequestMapping("/api/categories")
public class CategorieController {

	 @Autowired
	    private CategorieServices categorieServices;

	    @GetMapping
	    public List<Categorie> findAllcategoriees() {
	        return categorieServices.findAll();
	    }

	    @GetMapping("/{id}")
	    public Categorie findOnecategoriee(@PathVariable long id) {
	        return categorieServices.findOne(id);
	    }

	    @PostMapping
	    public Categorie addcategoriee(@RequestBody Categorie categorie) {
	        return categorieServices.AddOne(categorie);
	    }

	    @DeleteMapping("/{id}")
	    public void deletecategoriee(@PathVariable long id) {
	        categorieServices.DeleteOne(id);
	    }

}
