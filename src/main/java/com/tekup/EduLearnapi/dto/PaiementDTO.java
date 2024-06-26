package com.tekup.EduLearnapi.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PaiementDTO {

	    @NotBlank
	    private Double montant;

	    @NotBlank	    
	    private Date datePaiement;

	    @NotBlank
	    private String modePaiement;
	    
	    @JsonIgnoreProperties("paiements")
	    private UserDTO user;
	    
	    @JsonIgnoreProperties("paiement")
	    private CoursDTO cours;
}
