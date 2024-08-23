package com.tekup.EduLearnapi.mappers;

import org.modelmapper.ModelMapper;

import com.tekup.EduLearnapi.dto.CommentaireDTO;
import com.tekup.EduLearnapi.model.Commentaire;

public class CommentaireMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    static {
        // Configure ModelMapper to ignore ambiguity
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
    }

    public static CommentaireDTO convertToDto(Commentaire commentaire) {
        return modelMapper.map(commentaire, CommentaireDTO.class);
    }

    public static Commentaire convertToEntity(CommentaireDTO commentaireDTO) {
        return modelMapper.map(commentaireDTO, Commentaire.class);
    }
}
