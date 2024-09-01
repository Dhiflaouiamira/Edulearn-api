package com.tekup.EduLearnapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.tekup.EduLearnapi.Service.PaiementServices;
import com.tekup.EduLearnapi.dto.PaiementDTO;

import java.util.Optional;

@RestController
@RequestMapping("/api/paiements")
@RequiredArgsConstructor
public class PaiementController {

    @Autowired
    private final PaiementServices paiementServices;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STUDENT')")
    public ResponseEntity<Page<PaiementDTO>> getAllPaiements(Pageable pageable) {
        Page<PaiementDTO> paiements = paiementServices.getAllPaiements(pageable);
        return ResponseEntity.ok(paiements);
    }

    @PostMapping
    public ResponseEntity<PaiementDTO> createPaiement(@RequestBody PaiementDTO paiementDTO) {
        PaiementDTO createdPaiement = paiementServices.createPaiement(paiementDTO);
        return ResponseEntity.ok(createdPaiement);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STUDENT')")
    public ResponseEntity<PaiementDTO> getPaiement(@PathVariable Long id) {
        Optional<PaiementDTO> paiementOptional = paiementServices.findOnePaiement(id);
        return paiementOptional.map(ResponseEntity::ok)
                               .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<PaiementDTO> updatePaiement(@PathVariable Long id, @RequestBody PaiementDTO paiementDTO) {
        Optional<PaiementDTO> updatedPaiement = paiementServices.updateOnePaiement(id, paiementDTO);
        return updatedPaiement.map(ResponseEntity::ok)
                              .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> deleteOnePaiement(@PathVariable Long id) {
        paiementServices.deleteOnePaiement(id);
        return ResponseEntity.noContent().build();
    }
}
