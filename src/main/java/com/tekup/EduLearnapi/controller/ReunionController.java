package com.tekup.EduLearnapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.tekup.EduLearnapi.Service.ReunionServices;
import com.tekup.EduLearnapi.dto.ReunionDTO;

import java.util.Optional;

@RestController
@RequestMapping("/api/reunions")
@RequiredArgsConstructor
public class ReunionController {

    @Autowired
    private final ReunionServices reunionServices;

    @GetMapping
    public ResponseEntity<Page<ReunionDTO>> getAllReunions(Pageable pageable) {
        Page<ReunionDTO> reunions = reunionServices.getAllReunions(pageable);
        return ResponseEntity.ok(reunions);
    }

    @PostMapping
    public ResponseEntity<ReunionDTO> addReunion(@RequestBody ReunionDTO reunionDTO) {
        ReunionDTO savedReunion = reunionServices.addOneReunion(reunionDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedReunion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReunionDTO> getReunion(@PathVariable Long id) {
        Optional<ReunionDTO> reunionOptional = reunionServices.findOneReunion(id);
        return reunionOptional.map(ResponseEntity::ok)
                              .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ReunionDTO> updateReunion(@PathVariable Long id, @RequestBody ReunionDTO reunionDTO) {
        Optional<ReunionDTO> updatedReunion = reunionServices.updateOneReunion(id, reunionDTO);
        return updatedReunion.map(ResponseEntity::ok)
                             .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteOneReunion(@PathVariable long id) {
        reunionServices.deleteOneReunion(id);
    }
}
