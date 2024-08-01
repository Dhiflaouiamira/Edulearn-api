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
import jakarta.persistence.OneToMany;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    private String role;

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
    private Date dateDeNaissance;

    @Column(nullable = false)
    private byte[] photo;
    
    @Column(nullable = false, unique = true)
    private double telephone;

    @Column(nullable = false, unique = true)
    @NotBlank
    private String cin;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private Set<Cours> cours;

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
}
