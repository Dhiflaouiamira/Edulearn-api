package com.tekup.EduLearnapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Paiement extends BaseEntity {

    @Column(nullable = false)
    private double montant;

    @Column(nullable = false)
    private Date datePaiement;

    @Column(nullable = false)
    private String modePaiement;

    @OneToOne
    @JoinColumn(name = "cours_id", referencedColumnName = "id") // Foreign key to Cours
    private Cours cours;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false) // Foreign key to User
    private User user;
}
