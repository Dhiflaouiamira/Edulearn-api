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

import java.util.Date;

import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Commentaire extends BaseEntity {


    @Column(nullable = false)
    @NotBlank
    private String contenu;

    @Column(nullable = false)
    @NotBlank
    private Date dateCreation;
    
 
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    private Cours cours;

}
