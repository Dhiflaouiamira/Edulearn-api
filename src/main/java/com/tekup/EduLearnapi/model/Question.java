package com.tekup.EduLearnapi.model;


import java.util.List;


import javax.validation.constraints.NotBlank;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question extends BaseEntity {

	

    @Column(nullable = false)
    private String question;

    @NotBlank
    private String questionType;


    @ElementCollection
    private List<String> choices;


    @ElementCollection
    private List<String> correctAnswers;

    
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "chapitre_id", nullable = false) // Foreign key to User
    private Chapitre chapitre;
}




