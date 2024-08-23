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
import com.tekup.EduLearnapi.dto.BlogDTO;
import com.tekup.EduLearnapi.dto.CommentaireDTO;
import com.tekup.EduLearnapi.dto.CoursDTO;
import com.tekup.EduLearnapi.dto.PaiementDTO;
import com.tekup.EduLearnapi.dto.ReclamationDTO;
import com.tekup.EduLearnapi.dto.UserDTO;



@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserServices userServices;

    @GetMapping
    public ResponseEntity<Page<UserDTO>> getAllUsers(Pageable pageable) {
        Page<UserDTO> users = userServices.getAllUsers(pageable);
        return ResponseEntity.ok(users);
        
       
    }
    
 
    @PostMapping
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
        UserDTO savedUser = userServices.addOneUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping("/{id}")
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
    public void deleteOneUser(@PathVariable long id) {
        userServices.deleteOneUser(id);	
    }
   
   
    
    @PostMapping("/reclamation/{id}")
    public UserDTO assignToReclamation(@PathVariable long id,@RequestBody ReclamationDTO reclamation) {
        return userServices.assignReclamationToUser(id, reclamation);	
    }
    @GetMapping("/role/{role}")
    public ResponseEntity<Page<UserDTO>> getUsersByRole(
            @PathVariable("role") String role,
            Pageable pageable) {
        Page<UserDTO> users = userServices.getUsersByRole(role, pageable);
        return ResponseEntity.ok(users);
    }

    
    @PostMapping("/paiement/{id}")
    @PreAuthorize("hasAuthority('STUDENT')")
    public UserDTO assignToPaiement(@PathVariable long id,@RequestBody PaiementDTO paiement) {
        return userServices.assignPaiementToUser(id, paiement);	
    }
    
    @PostMapping("/cours/{id}")
    public UserDTO assignToCours(@PathVariable long id, @RequestBody CoursDTO cours) {
        return userServices.assignCoursToUser(id, cours);	
    }
    @PostMapping("/blog/{id}")
    public UserDTO assignToBlog(@PathVariable long id, @RequestBody BlogDTO blog) {
        return userServices.assignBlogToUser(id, blog);	
    }
    
}