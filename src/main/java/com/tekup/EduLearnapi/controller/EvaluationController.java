package com.tekup.EduLearnapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tekup.EduLearnapi.Service.EvaluationServices;
import com.tekup.EduLearnapi.dto.EvaluationDTO;

@RestController
@RequestMapping("/api/evaluations")
public class EvaluationController {

    @Autowired
    private EvaluationServices evaluationServices;

    @GetMapping
    public ResponseEntity<Page<EvaluationDTO>> getEvaluations(Pageable pageable) {
        Page<EvaluationDTO> evaluations = evaluationServices.getAllEvaluations(pageable);
        return ResponseEntity.ok(evaluations);
    }

    @PostMapping
    public ResponseEntity<EvaluationDTO> addOneEvaluation(@RequestBody EvaluationDTO evaluation) {
        EvaluationDTO savedEvaluation = evaluationServices.addOneEvaluation(evaluation);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEvaluation);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvaluationDTO> getEvaluation(@PathVariable Long id) {
        Optional<EvaluationDTO> evaluationOptional = evaluationServices.findOneEvaluation(id);
        return evaluationOptional.map(ResponseEntity::ok)
                                 .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EvaluationDTO> updateEvaluation(@PathVariable Long id, @RequestBody EvaluationDTO evaluationDTO) {
        Optional<EvaluationDTO> updatedEvaluation = evaluationServices.updateOneEvaluation(id, evaluationDTO);
        return updatedEvaluation.map(ResponseEntity::ok)
                                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOneEvaluation(@PathVariable Long id) {
        evaluationServices.deleteOneEvaluation(id);
        return ResponseEntity.noContent().build();
    }
}
