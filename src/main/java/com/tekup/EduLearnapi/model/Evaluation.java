package com.tekup.EduLearnapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Evaluation extends BaseEntity {

    @Column(nullable = false)
    @NotBlank
    private String titre;

    @Column(nullable = false)
    @NotBlank
    private String description;

    @Column(nullable = false)
    @NotNull
    private Date dateCreation;

    @Column(nullable = false)
    @NotNull
    private Date dateLimite;

    @Column(nullable = false)
    @NotNull
    private double coefficient;
    
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    private Chapitre chapitre;
}
