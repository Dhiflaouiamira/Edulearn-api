package com.tekup.EduLearnapi.Service;

import java.util.List;

import com.tekup.EduLearnapi.model.Categorie;

public interface CategorieServices {

	public List<Categorie> findAll();
	public Categorie findOne(long id);
	public Categorie AddOne(Categorie categorie);
	public void DeleteOne(long id);
}
