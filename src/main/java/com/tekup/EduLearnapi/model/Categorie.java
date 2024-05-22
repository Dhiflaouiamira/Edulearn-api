package com.tekup.EduLearnapi.model;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import java.util.Set;
import javax.validation.constraints.NotBlank;



@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Categorie extends BaseEntity {

    @Column(nullable = false)
    @NotBlank
    private String nom;

    @Column(nullable = false)
    @NotBlank
    private String description;
    
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.EAGER)
    private Set<Cours> cours;
    
}
