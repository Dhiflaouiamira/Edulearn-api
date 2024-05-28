package com.tekup.EduLearnapi.mappers;

import org.modelmapper.ModelMapper;

import com.tekup.EduLearnapi.dto.EvaluationDTO;
import com.tekup.EduLearnapi.model.Evaluation;

public class EvaluationMapper {

	private static final ModelMapper modelMapper= new ModelMapper();

	public static EvaluationDTO convertToDto(Evaluation evaluation)
	{
		return modelMapper.map(evaluation, EvaluationDTO.class);
	}
	public static Evaluation convertToEntity(EvaluationDTO evaluationDTO)
	{
		return modelMapper.map(evaluationDTO, Evaluation.class);
	}
}
