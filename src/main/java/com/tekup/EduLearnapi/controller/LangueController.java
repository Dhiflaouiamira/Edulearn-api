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
import com.tekup.EduLearnapi.Service.LangueServices;
import com.tekup.EduLearnapi.dto.CoursDTO;
import com.tekup.EduLearnapi.dto.LangueDTO;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/langues")
@RequiredArgsConstructor
public class LangueController {


    @Autowired
    private final LangueServices langueServices;

    @GetMapping
    public Page<LangueDTO> getLangues(Pageable pageable)
    {
    	return langueServices.getAllLangues(pageable);
    }

    @PostMapping
    public LangueDTO addOneLangue(@RequestBody LangueDTO langue)
    {
    return langueServices.addOneLangue(langue);	
    }

    @DeleteMapping("/{id}")
    public void deleteOneLangue(@PathVariable long id)
    {
    langueServices.deleteOneLangue(id);	
    }

    @PostMapping("/cours/{id}")
    public LangueDTO assignToCours(@PathVariable long id,@RequestBody CoursDTO cours)
    {
    return langueServices.assignCoursToLangue(id, cours);	
    }
    
}
