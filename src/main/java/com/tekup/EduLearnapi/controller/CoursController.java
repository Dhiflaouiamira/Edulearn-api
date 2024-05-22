package com.tekup.EduLearnapi.controller;

import com.tekup.EduLearnapi.model.Cours;
import com.tekup.EduLearnapi.Service.CoursServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CoursController {

    @Autowired
    private CoursServices coursServices;

    @GetMapping
    public List<Cours> findAllCourses() {
        return coursServices.findAll();
    }

    @GetMapping("/{id}")
    public Cours findOneCourse(@PathVariable long id) {
        return coursServices.findOne(id);
    }

    @PostMapping
    public Cours addCourse(@RequestBody Cours cours) {
        return coursServices.AddOne(cours);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable long id) {
        coursServices.DeleteOne(id);
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
