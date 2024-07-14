package com.tekup.EduLearnapi.dto;



import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LangueDTO {

	  @NotBlank
	    private Double nom;

	    @NotBlank	    
	    private Date code;
	    
	    @JsonIgnoreProperties("langue")
	    private List<CoursDTO> cours;
}
