package com.tekup.EduLearnapi.mappers;

import org.modelmapper.ModelMapper;

import com.tekup.EduLearnapi.dto.ReunionDTO;
import com.tekup.EduLearnapi.model.Reunion;

public class ReunionMapper {

	private static final ModelMapper modelMapper= new ModelMapper();

	public static ReunionDTO convertToDto(Reunion reunion)
	{
		return modelMapper.map(reunion, ReunionDTO.class);
	}
	public static Reunion convertToEntity(ReunionDTO reunionDTO)
	{
		return modelMapper.map(reunionDTO, Reunion.class);
	}
}
