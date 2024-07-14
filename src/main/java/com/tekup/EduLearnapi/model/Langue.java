package com.tekup.EduLearnapi.model;


import java.util.List;

import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Langue extends BaseEntity {

	@Column(nullable = false , unique= true)
    @NotBlank
    private String nom;

    @Column(nullable = false)
    @NotBlank
    private String code;
    
    @OneToMany(mappedBy = "langue")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Cours> cours;
}
