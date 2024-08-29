package com.tekup.EduLearnapi.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tekup.EduLearnapi.Service.CommentaireServices;
import com.tekup.EduLearnapi.dto.CommentaireDTO;

@RestController
@RequestMapping("/api/commentaires")
public class CommentaireController {

    @Autowired
    private CommentaireServices commentaireServices;

    @GetMapping
    public ResponseEntity<Page<CommentaireDTO>> getCommentaires(Pageable pageable) {
        Page<CommentaireDTO> commentaires = commentaireServices.getAllCommentaires(pageable);
        return ResponseEntity.ok(commentaires);
    }

    @PostMapping
    public ResponseEntity<CommentaireDTO> addOneCommentaire(@RequestBody CommentaireDTO commentaireDTO) {
        CommentaireDTO addedCommentaire = commentaireServices.addOneCommentaire(commentaireDTO);
        return ResponseEntity.ok(addedCommentaire);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOneCommentaire(@PathVariable long id) {
        commentaireServices.deleteOneCommentaire(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentaireDTO> findOneCommentaire(@PathVariable long id) {
        return commentaireServices.findOneCommentaire(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentaireDTO> updateCommentaire(@PathVariable long id, @RequestBody CommentaireDTO commentaireDTO) {
        return commentaireServices.updateOneCommentaire(id, commentaireDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
