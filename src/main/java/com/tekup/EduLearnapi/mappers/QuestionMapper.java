package com.tekup.EduLearnapi.mappers;

import org.modelmapper.ModelMapper;


import com.tekup.EduLearnapi.dto.QuestionDTO;
import com.tekup.EduLearnapi.model.Question;


public class QuestionMapper {

	private static final ModelMapper modelMapper= new ModelMapper();

	public static QuestionDTO convertToDto(Question question)
	{
		return modelMapper.map(question, QuestionDTO.class);
	}
	public static Question convertToEntity(QuestionDTO questionDTO)
	{
		return modelMapper.map(questionDTO, Question.class);
	}
}

