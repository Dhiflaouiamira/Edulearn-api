package com.tekup.EduLearnapi.mappers;

import org.modelmapper.ModelMapper;

import com.tekup.EduLearnapi.dto.LangueDTO;
import com.tekup.EduLearnapi.model.Langue;

public class LangueMapper {

	private static final ModelMapper modelMapper= new ModelMapper();

	public static LangueDTO convertToDto(Langue langue)
	{
		return modelMapper.map(langue, LangueDTO.class);
	}
	public static Langue convertToEntity(LangueDTO langueDTO)
	{
		return modelMapper.map(langueDTO, Langue.class);
	}
}
