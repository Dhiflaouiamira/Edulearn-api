package com.tekup.EduLearnapi.dto;

import java.util.Date;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CoursDTO {

    @NotBlank
    private String titre;

    @NotBlank
    private String description;

    @NotBlank
    private String niveau;

    @Positive
    private int duree;

    @NotBlank
    private Date dateDebut;

    @NotBlank
    private Date dateFin;

    @Positive  
    private double prix;

    @NotBlank
    private String sujet;

    @NotBlank
    private boolean certification;
    
    @JsonIgnoreProperties("cours")
	private Set<UserDTO> users;
    
    @JsonIgnoreProperties("cours")
	private Set<CategorieDTO> categories;
    
    @JsonIgnoreProperties("cours")
	private Set<ChapitreDTO> chapitres;
    
    @JsonIgnoreProperties("cours")
	private Set<CommentaireDTO> commentaires;

    @JsonIgnoreProperties("Cours")
    private LangueDTO langue;
    
    
    @JsonIgnoreProperties("cours")
    private PaiementDTO paiements;
}
