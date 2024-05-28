package com.tekup.EduLearnapi.Service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tekup.EduLearnapi.dto.EvaluationDTO;

public interface EvaluationServices {

	public Page<EvaluationDTO> getAllEvaluations(Pageable pageable) ;
	public EvaluationDTO addOneEvaluation(EvaluationDTO evaluation);
	public void deleteOneEvaluation(long id);
	public Optional<EvaluationDTO> findOneEvaluation(long id);
}
