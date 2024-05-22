package com.tekup.EduLearnapi.Service;

import java.util.List;

import com.tekup.EduLearnapi.model.Reclamation;

public interface ReclamationServices {

	public List<Reclamation> findAll();
	public Reclamation findOne(long id);
	public Reclamation AddOne(Reclamation reclamation);
	public void DeleteOne(long id);
}
