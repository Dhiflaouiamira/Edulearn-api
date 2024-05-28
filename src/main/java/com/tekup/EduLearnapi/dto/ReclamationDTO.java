package com.tekup.EduLearnapi.dto;

import java.sql.Date;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


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
