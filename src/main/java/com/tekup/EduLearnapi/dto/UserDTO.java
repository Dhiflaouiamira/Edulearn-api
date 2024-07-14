package com.tekup.EduLearnapi.dto;

import java.util.Date;


import java.util.List;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {

	    @NotBlank
	    private String nom;

	    @NotBlank
	    private String prenom;

	    @Email
	    @NotBlank
	    private String email;

	    @NotBlank
	    private String password;

	    private String role;
	    
        @Positive
	    private Date dateDeNaissance;
	    
        @Positive
	    private String telephone;

	    @NotBlank
	    private String cin;
	    
	    @JsonIgnoreProperties("user")
	    private List<CommentaireDTO> commentaires;
	    
	    @JsonIgnoreProperties("user")
	    private List<BlogDTO> blogs;
	    
	    @JsonIgnoreProperties("user")
	    private List<ReclamationDTO> reclamations;
	    
	    @JsonIgnoreProperties("user")
	    private List<PaiementDTO> paiements;
	    
	    @JsonIgnoreProperties("users")
	    private Set<CoursDTO> cours;
}
