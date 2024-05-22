package com.tekup.EduLearnapi.Service;

import java.util.List;

import com.tekup.EduLearnapi.model.Chapitre;

public interface ChapitreServices {

	
	public List<Chapitre> findAll();
	public Chapitre findOne(long id);
	public Chapitre AddOne(Chapitre chapitre);
	public void DeleteOne(long id);
}
