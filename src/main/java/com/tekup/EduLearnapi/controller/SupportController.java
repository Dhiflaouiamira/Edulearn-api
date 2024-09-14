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
import com.tekup.EduLearnapi.mappers.SupportMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/supports")
@RequiredArgsConstructor
public class SupportController {

    @Autowired
    private final SupportServices supportServices;

    // Admins and Support Staff can view all supports
    @GetMapping
    public ResponseEntity<Page<SupportDTO>> getAllSupports(Pageable pageable) {
        Page<SupportDTO> supports = supportServices.getAllSupports(pageable);
        return ResponseEntity.ok(supports);
    }

    // Admins can add supports
    @PostMapping
    public ResponseEntity<SupportDTO> addSupport(@RequestBody SupportDTO supportDTO) {
        SupportDTO savedSupport = supportServices.addOneSupport(supportDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSupport);
    }

    // Admins and Support Staff can view a specific support
    @GetMapping("/{id}")
    public ResponseEntity<SupportDTO> getSupport(@PathVariable Long id) {
        Optional<SupportDTO> supportOptional = supportServices.findOneSupport(id);
        return supportOptional.map(ResponseEntity::ok)
                              .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Admins can update supports
    @PutMapping("/{id}")
    public ResponseEntity<SupportDTO> updateSupport(@PathVariable Long id, @RequestBody SupportDTO supportDTO) {
        Optional<SupportDTO> updatedSupport = supportServices.updateOneSupport(id, supportDTO);
        return updatedSupport.map(ResponseEntity::ok)
                             .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Admins can delete supports
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOneSupport(@PathVariable long id) {
        supportServices.deleteOneSupport(id);
        return ResponseEntity.noContent().build();
    }

    // Admins and Support Staff can search supports by chapitre
    @GetMapping("/searchByChapitre")
    public ResponseEntity<List<SupportDTO>> findSupportByChapitre(@RequestParam String titre) {
        List<SupportDTO> supports = supportServices.findSupportByChapitre(titre)
                .stream()
                .map(SupportMapper::convertToDto)
                .collect(Collectors.toList());
        
        if (supports.isEmpty()) {
            return ResponseEntity.noContent().build(); // Return 204 No Content if no supports are found
        }
        return ResponseEntity.ok(supports); // Return 200 OK with the list of supports
    }
}
