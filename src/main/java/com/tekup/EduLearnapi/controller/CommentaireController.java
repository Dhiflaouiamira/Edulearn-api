package com.tekup.EduLearnapi.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tekup.EduLearnapi.Service.CommentaireServices;
import com.tekup.EduLearnapi.dto.CommentaireDTO;


@RestController
@RequestMapping("/api/commentaires")
public class CommentaireController {

	 @Autowired
	    private CommentaireServices commentaireServices;

	 @GetMapping
	    public Page<CommentaireDTO> getCommentaires(Pageable pageable)
	    {
	    	return commentaireServices.getAllCommentaires(pageable);
	    }

	    @PostMapping
	    public CommentaireDTO addOneCommentaire(@RequestBody CommentaireDTO commentaire)
	    {
	    return commentaireServices.addOneCommentaire(commentaire);	
	    }

	    @DeleteMapping("/{id}")
	    public void deleteOneCommentaire(@PathVariable long id)
	    {
	    commentaireServices.deleteOneCommentaire(id);	

	    }
}
