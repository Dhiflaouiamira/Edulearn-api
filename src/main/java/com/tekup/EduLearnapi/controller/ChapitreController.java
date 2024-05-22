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

import com.tekup.EduLearnapi.Service.ChapitreServices;
import com.tekup.EduLearnapi.model.Chapitre;



@RestController
@RequestMapping("/api/chapitres")
public class ChapitreController {

	 @Autowired
	    private ChapitreServices chapitreServices;

	    @GetMapping
	    public List<Chapitre> findAllchapitrees() {
	        return chapitreServices.findAll();
	    }

	    @GetMapping("/{id}")
	    public Chapitre findOnechapitree(@PathVariable long id) {
	        return chapitreServices.findOne(id);
	    }

	    @PostMapping
	    public Chapitre addchapitree(@RequestBody Chapitre chapitre) {
	        return chapitreServices.AddOne(chapitre);
	    }

	    @DeleteMapping("/{id}")
	    public void deletechapitree(@PathVariable long id) {
	        chapitreServices.DeleteOne(id);
	    }

}
