package com.tekup.EduLearnapi.Service;

import java.util.List;

import com.tekup.EduLearnapi.model.Evaluation;

public interface EvaluationServices {

	public List<Evaluation> findAll();
	public Evaluation findOne(long id);
	public Evaluation AddOne(Evaluation evaluation);
	public void DeleteOne(long id);
}
