package com.tekup.EduLearnapi.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ChapitreDTO {

	    @NotBlank
	    private String titre;

	    @NotBlank
	    private String description;

        @Positive
        private int ordre;
        
        @JsonIgnoreProperties("chapitres")
        private CoursDTO cours;
        
        @JsonIgnoreProperties("chapitre")
	    private List<ReunionDTO> reunions;
        
        @JsonIgnoreProperties("chapitre")
	    private List<EvaluationDTO> evaluations;
        
        @JsonIgnoreProperties("chapitre")
	    private List<SupportDTO> supports;
}
