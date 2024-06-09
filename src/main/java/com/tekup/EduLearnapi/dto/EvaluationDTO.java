package com.tekup.EduLearnapi.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EvaluationDTO {
	
    @NotBlank
    private String titre;

    @NotBlank
    private String description;

    @NotNull
    private Date dateCreation;

    @NotNull
    private Date dateLimite;

    @Positive
    @NotNull
    private double coefficient;
    
    @JsonIgnoreProperties("evaluations")
    private ChapitreDTO chapitre;
}
