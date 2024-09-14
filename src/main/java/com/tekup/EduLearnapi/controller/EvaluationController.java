package com.tekup.EduLearnapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.tekup.EduLearnapi.Service.EvaluationServices;
import com.tekup.EduLearnapi.dto.EvaluationDTO;

@RestController
@RequestMapping("/api/evaluations")
public class EvaluationController {

    @Autowired
    private EvaluationServices evaluationServices;

    // Only ADMIN and TEACHER can view all evaluations
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('TEACHER')")
    @GetMapping
    public ResponseEntity<Page<EvaluationDTO>> getEvaluations(Pageable pageable) {
        Page<EvaluationDTO> evaluations = evaluationServices.getAllEvaluations(pageable);
        return ResponseEntity.ok(evaluations);
    }

    // Only ADMIN and TEACHER can create an evaluation
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('TEACHER')")
    @PostMapping
    public ResponseEntity<EvaluationDTO> addOneEvaluation(@RequestBody EvaluationDTO evaluation) {
        EvaluationDTO savedEvaluation = evaluationServices.addOneEvaluation(evaluation);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEvaluation);
    }

    // ADMIN, TEACHER, and STUDENT can view a specific evaluation by ID
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('TEACHER') or hasAuthority('STUDENT')")
    @GetMapping("/{id}")
    public ResponseEntity<EvaluationDTO> getEvaluation(@PathVariable Long id) {
        Optional<EvaluationDTO> evaluationOptional = evaluationServices.findOneEvaluation(id);
        return evaluationOptional.map(ResponseEntity::ok)
                                 .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    // Only ADMIN and TEACHER can update an evaluation
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('TEACHER')")
    @PutMapping("/{id}")
    public ResponseEntity<EvaluationDTO> updateEvaluation(@PathVariable Long id, @RequestBody EvaluationDTO evaluationDTO) {
        Optional<EvaluationDTO> updatedEvaluation = evaluationServices.updateOneEvaluation(id, evaluationDTO);
        return updatedEvaluation.map(ResponseEntity::ok)
                                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    // Only ADMIN can delete an evaluation
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOneEvaluation(@PathVariable Long id) {
        evaluationServices.deleteOneEvaluation(id);
        return ResponseEntity.noContent().build();
    }
}
