package com.tekup.EduLearnapi.dto;

import java.util.Set;


import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CategorieDTO {

	 
    private Long id;
    
    @NotBlank
    private String nom;

    @NotBlank
    private String description;
    
    @Lob
    @NotBlank
    private byte[] image;
    
    @JsonIgnoreProperties("categories")
    private Set<CoursDTO> cours;
}
