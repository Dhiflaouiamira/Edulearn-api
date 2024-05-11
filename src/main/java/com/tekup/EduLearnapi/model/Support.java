package com.tekup.EduLearnapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

import java.util.Date;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Support extends BaseEntity {

    @Column(nullable = false)
    @NotBlank
    private String titre;

    @Column(nullable = false)
    @NotBlank
    private String description;

    @Column(nullable = false)
    @NotBlank
    private String fichierURL;

    @Column(nullable = false)
    private Date dateCreation;
    
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    private Chapitre chapitre;
}
