package com.tekup.EduLearnapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.tekup.EduLearnapi.Service.ChapitreServices;
import com.tekup.EduLearnapi.dto.ChapitreDTO;
import com.tekup.EduLearnapi.dto.ChapitreDTO;

@RestController
@RequestMapping("/api/chapitres")
public class ChapitreController {

    @Autowired
    private ChapitreServices chapitreServices;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('PROFESSEUR') or hasAuthority('ETUDIANT')")
    public Page<ChapitreDTO> getChapitres(Pageable pageable) {
        return chapitreServices.getAllChapitres(pageable);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('PROFESSEUR') or hasAuthority('ETUDIANT')")
    public ResponseEntity<ChapitreDTO> getOneChapitre(@PathVariable long id) {
        return chapitreServices.findOneChapitre(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('PROFESSEUR')")
    public ChapitreDTO addOneChapitre(@RequestBody ChapitreDTO chapitreDTO) {
        return chapitreServices.addOneChapitre(chapitreDTO);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('PROFESSEUR')")
    public ResponseEntity<ChapitreDTO> updateChapitre(@PathVariable long id, @RequestBody ChapitreDTO chapitreDTO) {
        return chapitreServices.updateOneChapitre(id, chapitreDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteOneChapitre(@PathVariable long id) {
        chapitreServices.deleteOneChapitre(id);
    }
}
