package com.tekup.EduLearnapi.Service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.tekup.EduLearnapi.dto.CommentaireDTO;
import com.tekup.EduLearnapi.mappers.CommentaireMapper;
import com.tekup.EduLearnapi.model.Commentaire;
import com.tekup.EduLearnapi.repository.CommentaireRepository;


@Service
public class commentaireServicesImpl implements CommentaireServices{
	@Autowired
	CommentaireRepository commentaireRepository;

	@Override
	public Page<CommentaireDTO> getAllCommentaires(Pageable pageable) {
		Page<Commentaire> commentaires=commentaireRepository.findAll(pageable);
		return commentaires.map(CommentaireMapper::convertToDto);
		
	}


	@Override
	public CommentaireDTO addOneCommentaire(CommentaireDTO commentaire) {
		return CommentaireMapper.convertToDto(commentaireRepository.save(CommentaireMapper.convertToEntity(commentaire)));

	}

	@Override
	public void deleteOneCommentaire(long id) {
		commentaireRepository.deleteById(id);		
	}



	@Override
	public Optional<CommentaireDTO> findOneCommentaire(long id) {
		return commentaireRepository.findById(id).map(CommentaireMapper::convertToDto);

	}
}
