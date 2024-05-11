package com.tekup.EduLearnapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

import java.sql.Date;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reclamation extends BaseEntity {

    @Column(nullable = false)
    @NotBlank
    private String sujet;

    @Column(nullable = false)
    @NotBlank
    private String description;

    @Column(nullable = false)
    private Date dateCreation;

    @Column(nullable = false)
    @NotBlank
    private String etat;

    @Column(nullable = false)
    @NotBlank
    private String texte;
    
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    private User user;
}
