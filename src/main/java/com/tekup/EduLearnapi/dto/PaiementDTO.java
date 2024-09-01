package com.tekup.EduLearnapi.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PaiementDTO {
    @NotNull
    @Positive
    private Double montant;

    @NotNull
    private Date datePaiement;

    @NotNull
    private String modePaiement;
    
    // Avoid circular references and use IDs for bi-directional relationships
    private Long userId; // User ID
    private Long coursId; // Cours ID

    // Use JsonIgnoreProperties for serialization to avoid infinite recursion
    @JsonIgnoreProperties("paiements")
    private UserDTO user;
    
    @JsonIgnoreProperties("paiement")
    private CoursDTO cours;
}
