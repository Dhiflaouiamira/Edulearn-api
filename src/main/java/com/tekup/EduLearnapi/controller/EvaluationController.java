package com.tekup.EduLearnapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tekup.EduLearnapi.Service.EvaluationServices;
import com.tekup.EduLearnapi.dto.EvaluationDTO;

@RestController
@RequestMapping("/api/evaluations")
public class EvaluationController {

	 @Autowired
	    private EvaluationServices evaluationServices;

	 @GetMapping
	    public Page<EvaluationDTO> getEvaluations(Pageable pageable)
	    {
	    	return evaluationServices.getAllEvaluations(pageable);
	    }

	    @PostMapping
	    public EvaluationDTO addOneEvaluation(@RequestBody EvaluationDTO evaluation)
	    {
	    return evaluationServices.addOneEvaluation(evaluation);	
	    }

	    @DeleteMapping("/{id}")
	    public void deleteOneEvaluation(@PathVariable long id)
	    {
	    evaluationServices.deleteOneEvaluation(id);	

	    }

}

