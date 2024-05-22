package com.tekup.EduLearnapi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.EduLearnapi.model.Evaluation;
import com.tekup.EduLearnapi.repository.EvaluationRepository;

@Service
public class EvaluationServicesimpl implements EvaluationServices {

	@Autowired
	EvaluationRepository evaluationRepository;
	
	@Override
	public List<Evaluation> findAll() {
		return evaluationRepository.findAll();
	}

	@Override
	public Evaluation findOne(long id) {
		return evaluationRepository.findById(id).orElse(null);

	}

	@Override
	public Evaluation AddOne(Evaluation evaluation) {
		return evaluationRepository.save(evaluation);
	}

	@Override
	public void DeleteOne(long id) {
		evaluationRepository.deleteById(id);
		
	}
}
