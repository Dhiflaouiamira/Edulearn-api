package com.tekup.EduLearnapi.Service;

import java.util.List;

import com.tekup.EduLearnapi.model.Langue;

public interface LangueServices {

	public List<Langue> findAll();
	public Langue findOne(long id);
	public Langue AddOne(Langue langue);
	public void DeleteOne(long id);
	public List<Langue> findLangueByNom(String nom);

}
