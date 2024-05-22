package com.tekup.EduLearnapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tekup.EduLearnapi.Service.CommentaireServices;
import com.tekup.EduLearnapi.model.Commentaire;


@RestController
@RequestMapping("/api/commentaires")
public class CommentaireController {

	 @Autowired
	    private CommentaireServices commentaireServices;

	    @GetMapping
	    public List<Commentaire> findAllCommentairees() {
	        return commentaireServices.findAll();
	    }

	    @GetMapping("/{id}")
	    public Commentaire findOneCommentairee(@PathVariable long id) {
	        return commentaireServices.findOne(id);
	    }

	    @PostMapping
	    public ResponseEntity<Commentaire> createCommentaire(@RequestBody Commentaire commentaire, @RequestParam long userId) {
	        Commentaire createdCommentaire = commentaireServices.AddOne(commentaire, userId);
	        return ResponseEntity.ok(createdCommentaire);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteCommentairee(@PathVariable long id) {
	        commentaireServices.DeleteOne(id);
	    }

	   
}
