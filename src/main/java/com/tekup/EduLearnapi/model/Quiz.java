package com.tekup.EduLearnapi.model;


import javax.validation.constraints.NotBlank;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Quiz extends BaseEntity {

	
	@Column(nullable = false)
	    @NotBlank
	    private String titre ;


    @Column(nullable = false)
    private int Score;

    @Column(nullable = false)
    private String questions;


    @Column(nullable = false)
    @NotBlank
    private int duree ;
    
  

}
