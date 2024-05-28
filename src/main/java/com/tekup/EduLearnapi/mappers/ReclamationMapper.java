package com.tekup.EduLearnapi.mappers;

import org.modelmapper.ModelMapper;

import com.tekup.EduLearnapi.dto.ReclamationDTO;
import com.tekup.EduLearnapi.model.Reclamation;

public class ReclamationMapper {

	private static final ModelMapper modelMapper= new ModelMapper();

	public static ReclamationDTO convertToDto(Reclamation reclamation)
	{
		return modelMapper.map(reclamation, ReclamationDTO.class);
	}
	public static Reclamation convertToEntity(ReclamationDTO reclamationDTO)
	{
		return modelMapper.map(reclamationDTO, Reclamation.class);
	}
}
