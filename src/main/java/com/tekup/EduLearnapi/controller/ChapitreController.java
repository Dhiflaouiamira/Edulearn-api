package com.tekup.EduLearnapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tekup.EduLearnapi.Service.ChapitreServices;
import com.tekup.EduLearnapi.dto.SupportDTO;
import com.tekup.EduLearnapi.dto.ChapitreDTO;

@RestController
@RequestMapping("/api/chapitres")
public class ChapitreController {

    @Autowired
    private ChapitreServices chapitreServices;

    @GetMapping
    public Page<ChapitreDTO> getChapitres(Pageable pageable) {
        return chapitreServices.getAllChapitres(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChapitreDTO> getOneChapitre(@PathVariable long id) {
        return chapitreServices.findOneChapitre(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ChapitreDTO addOneChapitre(@RequestBody ChapitreDTO chapitreDTO) {
        return chapitreServices.addOneChapitre(chapitreDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChapitreDTO> updateChapitre(@PathVariable long id, @RequestBody ChapitreDTO chapitreDTO) {
        return chapitreServices.updateOneChapitre(id, chapitreDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deleteOneChapitre(@PathVariable long id) {
        chapitreServices.deleteOneChapitre(id);
    }
    
    @PostMapping("/support/{id}")
    public ChapitreDTO assignToSupport(@PathVariable long id, @RequestBody SupportDTO support) {
        return chapitreServices.assignSupportToChapitre(id, support);	
    }
}
