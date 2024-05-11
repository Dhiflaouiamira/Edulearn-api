package com.tekup.EduLearnapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.Date;
import java.util.Set;

import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reunion extends BaseEntity {

    @Column(nullable = false)
    @NotBlank
    private String sujet;

    @Column(nullable = false)
    @NotBlank
    private String description;

    @Column(nullable = false)
    private Date dateDebut;

    @Column(nullable = false)
    private Date dateFin;
    
    @ManyToMany(mappedBy = "reunions")
  	private Set<Chapitre>  chapitres;
}
