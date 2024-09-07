package com.tekup.EduLearnapi.dto;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {

    private Long id;

    @NotBlank(message = "Name cannot be blank")
    private String nom;

    @NotBlank(message = "Surname cannot be blank")
    private String prenom;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email cannot be blank")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    private String password;

    @NotBlank(message = "Role cannot be blank")
    private String role;

    @Past(message = "Date of Birth must be in the past")
    private Date dateDeNaissance;

    @NotBlank(message = "Telephone number cannot be blank")
    private double telephone; // Changed to String to handle large numbers

    @NotBlank(message = "CIN cannot be blank")
    private String cin;

    @NotBlank(message = "Gender cannot be blank")
    private String genre;

    @Lob
    @NotBlank(message = "Image URL cannot be blank")
    private String image;

    @JsonIgnoreProperties("user")
    private List<CommentaireDTO> commentaires;
    
    @JsonIgnoreProperties("user")
    private List<PaiementDTO> paiements;
    
    @JsonIgnoreProperties("user")
    private List<ReclamationDTO> reclamations;

    @JsonIgnoreProperties("user")
    private Set<CoursDTO> cours;
}
