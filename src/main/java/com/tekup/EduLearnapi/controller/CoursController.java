package com.tekup.EduLearnapi.controller;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tekup.EduLearnapi.Service.CoursServices;
import com.tekup.EduLearnapi.dto.ChapitreDTO;
import com.tekup.EduLearnapi.dto.CommentaireDTO;
import com.tekup.EduLearnapi.dto.CoursDTO;
import com.tekup.EduLearnapi.dto.LangueDTO;
import com.tekup.EduLearnapi.dto.PaiementDTO;
import com.tekup.EduLearnapi.mappers.CoursMapper;
import com.tekup.EduLearnapi.model.Cours;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Optional;
import java.util.Set;
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

    @PostMapping("/add/{langueId}/user/{userId}")
    public ResponseEntity<LangueDTO> addCourseAndAssign(
            @PathVariable long langueId,
            @PathVariable long userId,
            @RequestBody CoursDTO coursDTO) {

        try {
            LangueDTO updatedLangue = coursServices.addCourseAndAssign(coursDTO, langueId, userId);
            return ResponseEntity.ok(updatedLangue);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
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

    

    @GetMapping("/searchByLangue")
    public ResponseEntity<List<CoursDTO>> findCoursesByLangue(@RequestParam String langue) {
        List<CoursDTO> courses = coursServices.findCoursesByLangue(langue)
                .stream()
                .map(CoursMapper::convertToDto) 
                .collect(Collectors.toList());
        if (courses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(courses); 
    }
    
 
    
    @PostMapping("/chapitre/{id}")
    public CoursDTO assignToChapitre(@PathVariable long id, @RequestBody ChapitreDTO chapitre) {
        return coursServices.assignChapitreToCours(id, chapitre);	
    } 
    
    @PostMapping("/commentaire/{id}")
    public CoursDTO assignToCommentaire(@PathVariable long id,@RequestBody CommentaireDTO commentaire) {
        return coursServices.assignCommentaireToCours(id, commentaire);	
    }
    
    @PostMapping("/paiement/{id}")
    public CoursDTO assignToPaiement(@PathVariable long id,@RequestBody PaiementDTO paiement) {
        return coursServices.assignPaiementToCours(id, paiement);	
    }
    
    @PutMapping("/{categorieId}/categorie/{coursId}")
    public ResponseEntity<CoursDTO> assignCoursToCategorie(
            @PathVariable Long coursId,
            @PathVariable Long categorieId
    ) {
        try {
            CoursDTO coursDTO = coursServices.assignCategorieToCours(coursId, categorieId);
            return ResponseEntity.ok(coursDTO);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
    
    @PutMapping("/{userId}/user/{coursId}")
    public ResponseEntity<CoursDTO> assignCoursToUser(
            @PathVariable Long coursId,
            @PathVariable Long userId
    ) {
        try {
            CoursDTO coursDTO = coursServices.assignUserToCours(coursId, userId);
            return ResponseEntity.ok(coursDTO);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
    
    @GetMapping("/category/{categorieId}")
    public ResponseEntity<Set<Cours>> getCoursesByCategory(@PathVariable Long categorieId) {
        Set<Cours> courses = coursServices.getCoursesByCategory(categorieId);
        if (courses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(courses);
    }
 
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CoursDTO>> getCoursesByUser(@PathVariable Long userId) {
    	 List<CoursDTO> courses = coursServices.getCoursesByUser(userId)
        		 .stream()
                .map(CoursMapper::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(courses);
    }
    
    @GetMapping("/description")
    public ResponseEntity<List<CoursDTO>> findCoursesByDescription(@RequestParam String description) {
        List<CoursDTO> courses = coursServices.findCoursesBydesc(description)
                .stream()
                .map(CoursMapper::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(courses);
    }
    
    

}
