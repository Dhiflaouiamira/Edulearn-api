package com.tekup.EduLearnapi.dto;

import java.util.Date;

import java.util.Set;

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
public class CoursDTO {

	
	
    private Long id;

    @NotBlank
    private String titre;

    @NotBlank
    private String description;

    @NotBlank
    private String niveau;

    @Positive
    private int duree;

    @NotNull
    private String cover;
    
    @NotNull
    private Date dateDebut;

    @NotNull
    private Date dateFin;

    @Positive  
    private double prix;
    
  
    @NotBlank
    private String sujet;

    @NotBlank
    private boolean certification;
    
    // Use IDs or minimal representation to avoid circular references
    @JsonIgnoreProperties("cours")
    private Set<UserDTO> users;
    
    @JsonIgnoreProperties("cours")
    private Set<CategorieDTO> categories;
    
    @JsonIgnoreProperties("cours")
    private Set<ChapitreDTO> chapitres;
    
    @JsonIgnoreProperties("cours")
    private Set<CommentaireDTO> commentaires;

    // Reference to Langue by its ID
    private Long langueId;

    @JsonIgnoreProperties("cours")
    private PaiementDTO paiements;
}
