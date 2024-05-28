package com.tekup.EduLearnapi.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class SupportDTO {

    @NotBlank
    private String titre;

    @NotBlank
    private String description;

    @NotBlank
    private String fichierURL;
    
    @NotBlank
    private Date dateCreation;
    
    @JsonIgnoreProperties("supports")
    private ChapitreDTO chapitre;
}
