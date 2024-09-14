package com.tekup.EduLearnapi.controller;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tekup.EduLearnapi.Service.LangueServices;
import com.tekup.EduLearnapi.dto.LangueDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/langues")
@RequiredArgsConstructor
public class LangueController {

    private final LangueServices langueServices;

    // Get all languages with pagination
    @GetMapping
    public ResponseEntity<Page<LangueDTO>> getLangues(Pageable pageable) {
        Page<LangueDTO> langues = langueServices.getAllLangues(pageable);
        return ResponseEntity.ok(langues);
    }

    // Create a new language
    @PostMapping
    public ResponseEntity<LangueDTO> addOneLangue(@RequestBody LangueDTO langue) {
        LangueDTO savedLangue = langueServices.addOneLangue(langue);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLangue);
    }

    // Get a language by ID
    @GetMapping("/{id}")
    public ResponseEntity<LangueDTO> getLangue(@PathVariable Long id) {
        Optional<LangueDTO> langueOptional = langueServices.findOneLangue(id);
        return langueOptional.map(ResponseEntity::ok)
                             .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    // Update an existing language by ID
    @PutMapping("/{id}")
    public ResponseEntity<LangueDTO> updateLangue(@PathVariable Long id, @RequestBody LangueDTO langueDTO) {
        Optional<LangueDTO> updatedLangue = langueServices.updateOneLangue(id, langueDTO);
        return updatedLangue.map(ResponseEntity::ok)
                            .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    // Delete a language by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOneLangue(@PathVariable Long id) {
        langueServices.deleteOneLangue(id);
        return ResponseEntity.noContent().build();
    }
}
