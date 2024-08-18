package com.tekup.EduLearnapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.tekup.EduLearnapi.Service.CategorieServices;
import com.tekup.EduLearnapi.dto.CategorieDTO;

@RestController
@RequestMapping("/api/categories")
public class CategorieController {

    @Autowired
    private CategorieServices categorieServices;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('PROFESSEUR')")
    public Page<CategorieDTO> getCategories(Pageable pageable) {
        return categorieServices.getAllCategories(pageable);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('PROFESSEUR')")
    public ResponseEntity<CategorieDTO> getOneCategorie(@PathVariable long id) {
        return categorieServices.findOneCategorie(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<CategorieDTO> addOneCategorie(@RequestBody CategorieDTO categorieDTO) {
        CategorieDTO createdCategorie = categorieServices.addOneCategorie(categorieDTO);
        return ResponseEntity.ok(createdCategorie);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<CategorieDTO> updateOneCategorie(@PathVariable long id, @RequestBody CategorieDTO categorieDTO) {
        return categorieServices.updateOneCategorie(id, categorieDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> deleteOneCategorie(@PathVariable long id) {
        categorieServices.deleteOneCategorie(id);
        return ResponseEntity.noContent().build();
    }


}
