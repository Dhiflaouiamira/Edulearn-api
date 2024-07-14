package com.tekup.EduLearnapi.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.tekup.EduLearnapi.dto.EvaluationDTO;
import com.tekup.EduLearnapi.mappers.EvaluationMapper;
import com.tekup.EduLearnapi.model.Evaluation;
import com.tekup.EduLearnapi.repository.EvaluationRepository;

@Service
public class EvaluationServicesimpl implements EvaluationServices {
	@Autowired
	EvaluationRepository evaluationRepository;

	@Override
	public Page<EvaluationDTO> getAllEvaluations(Pageable pageable) {
		Page<Evaluation> evaluations=evaluationRepository.findAll(pageable);
		return evaluations.map(EvaluationMapper::convertToDto);
		
	}


	@Override
	public EvaluationDTO addOneEvaluation(EvaluationDTO evaluation) {
		return EvaluationMapper.convertToDto(evaluationRepository.save(EvaluationMapper.convertToEntity(evaluation)));

	}

	@Override
	public void deleteOneEvaluation(long id) {
		evaluationRepository.deleteById(id);		
	}



	@Override
	public Optional<EvaluationDTO> findOneEvaluation(long id) {
		return evaluationRepository.findById(id).map(EvaluationMapper::convertToDto);

	}
}
