package com.tekup.EduLearnapi.Service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.tekup.EduLearnapi.dto.CommentaireDTO;

public interface CommentaireServices {

	public Page<CommentaireDTO> getAllCommentaires(Pageable pageable) ;
	public CommentaireDTO addOneCommentaire(CommentaireDTO commentaire);
	public void deleteOneCommentaire(long id);
	public Optional<CommentaireDTO> findOneCommentaire(long id);
}
