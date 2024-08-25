package com.tekup.EduLearnapi.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.tekup.EduLearnapi.Service.CoursServices;
import com.tekup.EduLearnapi.dto.ChapitreDTO;
import com.tekup.EduLearnapi.dto.CommentaireDTO;
import com.tekup.EduLearnapi.dto.CoursDTO;
import com.tekup.EduLearnapi.mappers.CoursMapper;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CoursController {

    @Autowired
    private final CoursServices coursServices;

    @GetMapping
    public ResponseEntity<Page<CoursDTO>> getAllCours(Pageable pageable) {
        Page<CoursDTO> cours = coursServices.getAllCours(pageable);
        return ResponseEntity.ok(cours);
    }

    @PostMapping
    public ResponseEntity<CoursDTO> addOneCours(@RequestBody CoursDTO coursDTO) {
        CoursDTO savedCours = coursServices.addOneCours(coursDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCours);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoursDTO> getCours(@PathVariable Long id) {
        Optional<CoursDTO> coursOptional = coursServices.findOneCours(id);
        return coursOptional.map(ResponseEntity::ok)
                            .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CoursDTO> updateCours(@PathVariable Long id, @RequestBody CoursDTO coursDTO) {
        Optional<CoursDTO> updatedCours = coursServices.updateOneCours(id, coursDTO);
        return updatedCours.map(ResponseEntity::ok)
                           .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOneCours(@PathVariable Long id) {
        coursServices.deleteOneCours(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/searchByTitle")
    public ResponseEntity<List<CoursDTO>> findCoursesByTitre(@RequestParam String titre) {
        List<CoursDTO> courses = coursServices.findCoursesByTitre(titre)
                .stream()
                .map(CoursMapper::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(courses);
    }

    
    @GetMapping("/byDescription")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('PROFESSEUR')")
    public ResponseEntity<List<CoursDTO>> findCoursesByDescription(@RequestParam String description) {
        List<CoursDTO> courses = coursServices.findCoursesBydesc(description)
                .stream()
                .map(CoursMapper::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(courses);
    }
    
    @GetMapping("/searchByLangue")
    public ResponseEntity<List<CoursDTO>> findCoursesByLangue(@RequestParam String langue) {
        List<CoursDTO> courses = coursServices.findCoursesByLangue(langue)
                .stream()
                .map(CoursMapper::convertToDto) // Ensure this method exists and works correctly
                .collect(Collectors.toList());
        
        // Return the list of courses
        if (courses.isEmpty()) {
            return ResponseEntity.noContent().build(); // Return 204 No Content if no courses are found
        }

        return ResponseEntity.ok(courses); // Return 200 OK with the list of courses
    }
    
    @PostMapping("/chapitre/{id}")
    public CoursDTO assignToChapitre(@PathVariable long id, @RequestBody ChapitreDTO chapitre) {
        return coursServices.assignChapitreToCours(id, chapitre);	
    } 
    
    @PostMapping("/commentaire/{id}")
    public CoursDTO assignToCommentaire(@PathVariable long id,@RequestBody CommentaireDTO commentaire) {
        return coursServices.assignCommentaireToCours(id, commentaire);	
    }
    
    
}
