package com.tekup.EduLearnapi.mappers;

import org.modelmapper.ModelMapper;

import com.tekup.EduLearnapi.dto.CoursDTO;
import com.tekup.EduLearnapi.model.Cours;

public class CoursMapper {

	private static final ModelMapper modelMapper= new ModelMapper();

	public static CoursDTO convertToDto(Cours cours)
	{
		return modelMapper.map(cours, CoursDTO.class);
	}
	public static Cours convertToEntity(CoursDTO coursDTO)
	{
		return modelMapper.map(coursDTO, Cours.class);
	}
}