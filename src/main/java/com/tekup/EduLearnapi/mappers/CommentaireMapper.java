package com.tekup.EduLearnapi.mappers;

import org.modelmapper.ModelMapper;

import com.tekup.EduLearnapi.dto.CommentaireDTO;
import com.tekup.EduLearnapi.model.Commentaire;

public class CommentaireMapper {
	private static final ModelMapper modelMapper= new ModelMapper();

	public static CommentaireDTO convertToDto(Commentaire commentaire)
	{
		return modelMapper.map(commentaire, CommentaireDTO.class);
	}
	public static Commentaire convertToEntity(CommentaireDTO commentaireDTO)
	{
		return modelMapper.map(commentaireDTO, Commentaire.class);
	}
}
