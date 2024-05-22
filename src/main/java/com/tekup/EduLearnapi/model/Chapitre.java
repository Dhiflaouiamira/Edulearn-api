package com.tekup.EduLearnapi.model;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
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
public class Chapitre extends BaseEntity {



    @Column(nullable = false)
    @NotBlank
    private String titre;

    @Column(nullable = false)
    @NotBlank
    private String description;

    @Column(nullable = false)
    private Integer ordre;
    
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    private Cours cours;
    
    @OneToMany(mappedBy = "chapitre")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Evaluation> evaluations;
    
    @OneToMany(mappedBy = "chapitre")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Support> supports;
    
    @OneToMany(mappedBy = "chapitre")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Reunion> reunions;
    
}
