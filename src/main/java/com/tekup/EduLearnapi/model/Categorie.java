package com.tekup.EduLearnapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    
    @OneToMany(mappedBy = "categorie")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Cours> cours;
    
}
