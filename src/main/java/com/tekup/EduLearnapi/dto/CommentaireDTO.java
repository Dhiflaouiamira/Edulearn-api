package com.tekup.EduLearnapi.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class CommentaireDTO {

	    @NotBlank
	    private String contenu;

	    @NotBlank
	    private Date dateCreation;
	    
	    @JsonIgnoreProperties("commemtaires")
	    private UserDTO user;
	    
	    @JsonIgnoreProperties("commemtaires")
        private CoursDTO cours;
}
