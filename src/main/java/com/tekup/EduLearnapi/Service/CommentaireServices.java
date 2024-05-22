package com.tekup.EduLearnapi.Service;

import java.util.List;

import com.tekup.EduLearnapi.model.Commentaire;

public interface CommentaireServices {

	public List<Commentaire> findAll();
	public Commentaire findOne(long id);
	public Commentaire AddOne(Commentaire commentaire, long idUser);
	public void DeleteOne(long id);
}
