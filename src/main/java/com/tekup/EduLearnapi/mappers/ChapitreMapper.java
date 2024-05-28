package com.tekup.EduLearnapi.mappers;

import org.modelmapper.ModelMapper;

import com.tekup.EduLearnapi.dto.ChapitreDTO;
import com.tekup.EduLearnapi.model.Chapitre;

public class ChapitreMapper {
	private static final ModelMapper modelMapper= new ModelMapper();

	public static ChapitreDTO convertToDto(Chapitre chapitre)
	{
		return modelMapper.map(chapitre, ChapitreDTO.class);
	}
	public static Chapitre convertToEntity(ChapitreDTO chapitreDTO)
	{
		return modelMapper.map(chapitreDTO, Chapitre.class);
	}
}
