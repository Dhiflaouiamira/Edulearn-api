package com.tekup.EduLearnapi.dto;

import java.sql.Date;


import javax.validation.constraints.NotBlank;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReclamationDTO {

    private Long id; // Ensure you have an ID field

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

    private Long userId; // This should match the User ID in the system

    // Add other fields as needed
}
