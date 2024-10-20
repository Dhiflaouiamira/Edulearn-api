package com.tekup.EduLearnapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
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
public class Cours extends BaseEntity {

    @Column(nullable = false, unique = true)
    @NotBlank
    private String titre;

    @Column(nullable = false)
    @NotBlank
    private String description;

    @Column(nullable = false)
    @NotBlank
    private String niveau;

    @Column(nullable = false)
    private int duree;

    @Column(nullable = false)
    private Date dateDebut;

    @Column(nullable = false)
    private Date dateFin;

    @Column(nullable = false)
    private double prix;

    @Column(nullable = false)
    private String cover;

    @Column(nullable = false)
    @NotBlank
    private String sujet;

    @Column(nullable = false)
    private boolean certification;
    
    private int demandMeeting = 0;


    @ManyToMany
    @JoinTable(name = "user_cours",
               joinColumns = @JoinColumn(name = "cours_id"),
               inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> assignedUser = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "cours_categorie",
               joinColumns = @JoinColumn(name = "cours_id"),
               inverseJoinColumns = @JoinColumn(name = "categorie_id"))
    private Set<Categorie> assignedCategorie = new HashSet<>(); 
    

    @OneToMany(mappedBy = "cours")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Commentaire> commentaires;

    @OneToMany(mappedBy = "cours")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Chapitre> chapitres;

    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Langue langue;

    @OneToMany(mappedBy = "cours")
    private List<Paiement> paiements; // One-to-many relationship
}
