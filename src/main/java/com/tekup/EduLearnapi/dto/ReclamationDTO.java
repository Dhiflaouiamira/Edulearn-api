package com.tekup.EduLearnapi.dto;

import java.sql.Date;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReclamationDTO {

    @NotBlank
    private String sujet;

    @NotBlank
    private String description;
    
    @NotBlank
    private Date dateCreation;

    @NotBlank
    private String etat;

    @NotBlank
    private String texte;
    
    @JsonIgnoreProperties("reclamations")
    private UserDTO user;
}
