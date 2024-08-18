package com.tekup.EduLearnapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.tekup.EduLearnapi.Service.SupportServices;
import com.tekup.EduLearnapi.dto.SupportDTO;

import java.util.Optional;

@RestController
@RequestMapping("/api/supports")
@RequiredArgsConstructor
public class SupportController {

    @Autowired
    private final SupportServices supportServices;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Page<SupportDTO>> getAllSupports(Pageable pageable) {
        Page<SupportDTO> supports = supportServices.getAllSupports(pageable);
        return ResponseEntity.ok(supports);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<SupportDTO> addSupport(@RequestBody SupportDTO supportDTO) {
        SupportDTO savedSupport = supportServices.addOneSupport(supportDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSupport);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('PROFESSEUR')")
    public ResponseEntity<SupportDTO> getSupport(@PathVariable Long id) {
        Optional<SupportDTO> supportOptional = supportServices.findOneSupport(id);
        return supportOptional.map(ResponseEntity::ok)
                              .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<SupportDTO> updateSupport(@PathVariable Long id, @RequestBody SupportDTO supportDTO) {
        Optional<SupportDTO> updatedSupport = supportServices.updateOneSupport(id, supportDTO);
        return updatedSupport.map(ResponseEntity::ok)
                             .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteOneSupport(@PathVariable long id) {
        supportServices.deleteOneSupport(id);
    }
}
