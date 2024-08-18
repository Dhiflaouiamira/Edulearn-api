package com.tekup.EduLearnapi.dto;




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
	    private String nom;

	    @NotBlank	    
	    private String code;
	    
	    @JsonIgnoreProperties("langue")
	    private List<CoursDTO> cours;
}
