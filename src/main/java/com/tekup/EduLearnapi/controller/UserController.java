package com.tekup.EduLearnapi.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.tekup.EduLearnapi.Service.UserServices;
import com.tekup.EduLearnapi.dto.CoursDTO;
import com.tekup.EduLearnapi.dto.UserDTO;
import com.tekup.EduLearnapi.model.Commentaire;
import com.tekup.EduLearnapi.model.Paiement;
import com.tekup.EduLearnapi.model.Reclamation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserServices userServices;

    @GetMapping
    public Page<UserDTO> getUsers(Pageable pageable)
    {
    	return userServices.getAllUsers(pageable);
    }

    @PostMapping
    public UserDTO addOneUser(@RequestBody UserDTO user)
    {
    return userServices.addOneUser(user);	
    }

    @DeleteMapping("/{id}")
    public void deleteOneUser(@PathVariable long id)
    {
    userServices.deleteOneUser(id);	
    }
   
    @PostMapping("/commentaire/{id}")
    public UserDTO assignToCommentaire(@PathVariable long id,@RequestBody Commentaire commentaire)
    {
    return userServices.assignCommentaireToUser(id, commentaire);	
    }
    
    @PostMapping("/reclamation/{id}")
    public UserDTO assignToReclamation(@PathVariable long id,@RequestBody Reclamation reclamation)
    {
    return userServices.assignReclamationToUser(id, reclamation);	
    }
    
    @PostMapping("/paiement/{id}")
    public UserDTO assignToPaiement(@PathVariable long id,@RequestBody Paiement paiement)
    {
    return userServices.assignPaiementToUser(id, paiement);	
    }
    
    @PostMapping("/Cours/{id}")
    public UserDTO assignToCours(@PathVariable long id, @RequestBody CoursDTO cours)
    {
    return userServices.assignCoursToUser(id, cours);	
    }
}
