package com.tekup.EduLearnapi.mappers;

import org.modelmapper.ModelMapper;

import com.tekup.EduLearnapi.dto.CategorieDTO;
import com.tekup.EduLearnapi.model.Categorie;

public class CategorieMapper {

	private static final ModelMapper modelMapper= new ModelMapper();

	public static CategorieDTO convertToDto(Categorie categorie)
	{
		return modelMapper.map(categorie, CategorieDTO.class);
	}
	public static Categorie convertToEntity(CategorieDTO categorieDTO)
	{
		return modelMapper.map(categorieDTO, Categorie.class);
	}
}
