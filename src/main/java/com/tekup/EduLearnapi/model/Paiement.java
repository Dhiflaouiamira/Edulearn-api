package com.tekup.EduLearnapi.model;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

import java.util.Date;

import javax.validation.constraints.NotBlank; 

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Paiement extends BaseEntity{



    @Column(nullable = false)
    @NotBlank
    private double montant;

    @Column(nullable = false)
    private Date datePaiement;

    @Column(nullable = false)
    private String modePaiement;
    
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    private User user;
    
    @MapsId
    @OneToOne(optional = false)
    @JoinColumn(name = "id")
    private Cours cours;

}
