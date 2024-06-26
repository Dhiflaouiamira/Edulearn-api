package com.tekup.EduLearnapi.dto;

import java.util.Set;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CategorieDTO {

    @NotBlank
    private String nom;

    @NotBlank
    private String description;
    
    @JsonIgnoreProperties("categories")
    private Set<CoursDTO> cours;
}
