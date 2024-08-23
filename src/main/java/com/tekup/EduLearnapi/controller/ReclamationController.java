package com.tekup.EduLearnapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.tekup.EduLearnapi.Service.ReclamationServices;
import com.tekup.EduLearnapi.dto.ReclamationDTO;

import java.util.Optional;

@RestController
@RequestMapping("/api/reclamations")
@RequiredArgsConstructor
public class ReclamationController {

    @Autowired
    private final ReclamationServices reclamationServices;

    @GetMapping
    public ResponseEntity<Page<ReclamationDTO>> getAllReclamations(Pageable pageable) {
        Page<ReclamationDTO> reclamations = reclamationServices.getAllReclamations(pageable);
        return ResponseEntity.ok(reclamations);
    }

    @PostMapping
    public ResponseEntity<ReclamationDTO> addOneReclamation(@RequestBody ReclamationDTO reclamationDTO) {
        ReclamationDTO savedReclamation = reclamationServices.addOneReclamation(reclamationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedReclamation);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReclamationDTO> getReclamation(@PathVariable Long id) {
        Optional<ReclamationDTO> reclamationOptional = reclamationServices.findOneReclamation(id);
        return reclamationOptional.map(ResponseEntity::ok)
                                  .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReclamationDTO> updateReclamation(@PathVariable Long id, @RequestBody ReclamationDTO reclamationDTO) {
        Optional<ReclamationDTO> updatedReclamation = reclamationServices.updateOneReclamation(id, reclamationDTO);
        return updatedReclamation.map(ResponseEntity::ok)
                                  .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @DeleteMapping("/{id}")
    public void deleteOneReclamation(@PathVariable long id) {
        reclamationServices.deleteOneReclamation(id);
    }
}
