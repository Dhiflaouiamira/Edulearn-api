package com.tekup.EduLearnapi.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.tekup.EduLearnapi.Service.UserServices;
import com.tekup.EduLearnapi.dto.CommentaireDTO;
import com.tekup.EduLearnapi.dto.CoursDTO;
import com.tekup.EduLearnapi.dto.PaiementDTO;
import com.tekup.EduLearnapi.dto.ReclamationDTO;
import com.tekup.EduLearnapi.dto.UserDTO;



@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserServices userServices;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Page<UserDTO>> getAllUsers(Pageable pageable) {
        Page<UserDTO> users = userServices.getAllUsers(pageable);
        return ResponseEntity.ok(users);
    }
    
 
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
        UserDTO savedUser = userServices.addOneUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('PROFESSEUR')")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        Optional<UserDTO> userOptional = userServices.findOneUser(id);
        return userOptional.map(ResponseEntity::ok)
                           .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
    
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        Optional<UserDTO> updatedUser = userServices.updateOneUser(id, userDTO);
        return updatedUser.map(ResponseEntity::ok)
                          .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
    
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteOneUser(@PathVariable long id) {
        userServices.deleteOneUser(id);	
    }
   
    @PostMapping("/commentaire/{id}")
    public UserDTO assignToCommentaire(@PathVariable long id,@RequestBody CommentaireDTO commentaire) {
        return userServices.assignCommentaireToUser(id, commentaire);	
    }
    
    @PostMapping("/reclamation/{id}")
    public UserDTO assignToReclamation(@PathVariable long id,@RequestBody ReclamationDTO reclamation) {
        return userServices.assignReclamationToUser(id, reclamation);	
    }
    
    @PostMapping("/paiement/{id}")
    @PreAuthorize("hasAuthority('ETUDIANT')")
    public UserDTO assignToPaiement(@PathVariable long id,@RequestBody PaiementDTO paiement) {
        return userServices.assignPaiementToUser(id, paiement);	
    }
    
    @PostMapping("/Cours/{id}")
    public UserDTO assignToCours(@PathVariable long id, @RequestBody CoursDTO cours) {
        return userServices.assignCoursToUser(id, cours);	
    }
}