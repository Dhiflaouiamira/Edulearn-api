package com.tekup.EduLearnapi.dto;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class EvaluationDTO {
	
    @NotBlank
    private String titre;

    @NotBlank
    private String description;

    @NotNull
    private Date dateCreation;

    @NotNull
    private Date dateLimite;

    @NotNull
    private double coefficient;
    
    @JsonIgnoreProperties("evaluations")
    private ChapitreDTO chapitre;
}
