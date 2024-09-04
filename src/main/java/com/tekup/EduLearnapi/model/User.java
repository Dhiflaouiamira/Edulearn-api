package com.tekup.EduLearnapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    @Column(nullable = false)
    @NotBlank
    private String nom;

    @Column(nullable = false)
    @NotBlank
    private String prenom;

    @Column(nullable = false)
    @NotBlank
    private String genre;

    @Email
    @Column(nullable = false, unique = true)
    @NotBlank
    private String email;

    @Column(nullable = false, unique = true)
    @NotBlank
    private String password;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateDeNaissance;

    @Column(nullable = false)
    private double telephone; // Changed to String

    @Column(nullable = false, unique = true)
    @NotBlank
    private String cin;

    @Lob
    @Column(nullable = false)
    @NotBlank
    private String image;

    @ManyToMany(mappedBy = "assignedUser")
    private Set<Cours> Cours = new HashSet<>();

    @OneToMany(mappedBy = "user")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Commentaire> commentaires;

    @OneToMany(mappedBy = "user")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Reclamation> reclamations;

    @OneToMany(mappedBy = "user")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Paiement> paiements;

    @OneToMany(mappedBy = "user")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Blog> blogs;

    @Column(nullable = false)
    @NotBlank
    private String role;
}
