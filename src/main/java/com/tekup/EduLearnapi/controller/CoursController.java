package com.tekup.EduLearnapi.controller;

import com.tekup.EduLearnapi.model.Cours;
import com.tekup.EduLearnapi.Service.CoursServices;
import com.tekup.EduLearnapi.dto.CoursDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CoursController {

    @Autowired
    private CoursServices coursServices;

    @GetMapping
    public Page<CoursDTO> getCours(Pageable pageable)
    {
    	return coursServices.getAllCours(pageable);
    }

    @PostMapping
    public CoursDTO addOneCours(@RequestBody CoursDTO cours)
    {
    return coursServices.addOneCours(cours);	
    }

    @DeleteMapping("/{id}")
    public void deleteOneCours(@PathVariable long id)
    {
    coursServices.deleteOneCours(id);	
    
    }
    @GetMapping("/byTitre")
    public List<Cours> findCoursesByTitre(@RequestParam String titre) {
        return coursServices.findCoursesByTitre(titre);
    }

    @GetMapping("/byDescription")
    public List<Cours> findCoursesByDescription(@RequestParam String description) {
        return coursServices.findCoursesBydesc(description);
    }
}
