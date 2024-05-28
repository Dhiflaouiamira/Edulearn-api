package com.tekup.EduLearnapi.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class ReunionDTO {

    @NotBlank
    private String sujet;

    @NotBlank
    private String description;
    
    @NotBlank
    private Date dateDebut;

    @NotBlank
    private Date dateFin;
    
    @JsonIgnoreProperties("reunions")
    private ChapitreDTO chapitre;
}
