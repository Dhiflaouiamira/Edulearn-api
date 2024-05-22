package com.tekup.EduLearnapi.Service;


import java.util.List;
import com.tekup.EduLearnapi.model.Cours;
public interface CoursServices {

	public List<Cours> findAll();
	public Cours findOne(long id);
	public Cours AddOne(Cours cours);
	public void DeleteOne(long id);
	public List<Cours> findCoursesByTitre(String titre);
	public List<Cours> findCoursesBydesc(String description);}
