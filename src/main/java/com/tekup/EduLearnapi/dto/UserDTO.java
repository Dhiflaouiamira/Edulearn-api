package com.tekup.EduLearnapi.dto;

import java.util.Date;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;

public class UserDTO {

	  @Column(nullable = false)
	    @NotBlank
	    private String nom;

	    @Column(nullable = false)
	    @NotBlank
	    private String prenom;

	    @Email
	    @Column(nullable = false, unique = true)
	    @NotBlank
	    private String email;

	    @Column(nullable = false,unique = true)
	    @NotBlank
	    private String password;

	    @Column(nullable = false)
	    private String role;

	    @Column(nullable = false)
	    private Date dateDeNaissance;

	    @Column(nullable = false, unique = true)
	    private String telephone;

	    @Column(nullable = false, unique = true)
	    @NotBlank
	    private String cin;
	    
	    @JsonIgnoreProperties("user")
	    private List<CommentaireDTO> commentaires;
	    
	    @JsonIgnoreProperties("user")
	    private List<ReclamationDTO> reclamations;
	    
	    @JsonIgnoreProperties("user")
	    private List<PaiementDTO> paiements;
	    
	    @JsonIgnoreProperties("users")
	    private Set<CoursDTO> cours;
}
