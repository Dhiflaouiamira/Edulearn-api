package com.tekup.EduLearnapi.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class LangueDTO {

	    @NotBlank 
	    private String nom;

	    @NotBlank 
	    private String code;
	    
	    @JsonIgnoreProperties("langue")
	    private CoursDTO cours;
}
