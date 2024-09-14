package com.tekup.EduLearnapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.tekup.EduLearnapi.Service.UserServices;
import com.tekup.EduLearnapi.dto.BlogDTO;
import com.tekup.EduLearnapi.dto.PaiementDTO;
import com.tekup.EduLearnapi.dto.ReclamationDTO;
import com.tekup.EduLearnapi.dto.UserDTO;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServices userServices;

    // Admins and Teachers can view all users
    @GetMapping
    public ResponseEntity<Page<UserDTO>> getAllUsers(Pageable pageable) {
        Page<UserDTO> users = userServices.getAllUsers(pageable);
        return ResponseEntity.ok(users);
    }

    // Admins can add users
    @PostMapping
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
        UserDTO savedUser = userServices.addOneUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    // Admins, Teachers, and the user themselves can view user details
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        return userServices.findOneUser(id)
                           .map(ResponseEntity::ok)
                           .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Admins can update users
    @PutMapping("/{id}" )
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return userServices.updateOneUser(id, userDTO)
                           .map(ResponseEntity::ok)
                           .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Admins can delete users
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOneUser(@PathVariable long id) {
        userServices.deleteOneUser(id);
        return ResponseEntity.noContent().build();
    }

    // Admins and Teachers can assign reclamations to users
    @PostMapping("/{userId}/reclamation")
    public ResponseEntity<UserDTO> assignToReclamation(@PathVariable long userId, @RequestBody ReclamationDTO reclamationDTO) {
        try {
            UserDTO userDTO = userServices.assignReclamationToUser(userId, reclamationDTO);
            return ResponseEntity.ok(userDTO);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Admins and Teachers can view users by role
    @GetMapping("/role/{role}")
    public ResponseEntity<Page<UserDTO>> getUsersByRole(@PathVariable String role, Pageable pageable) {
        Page<UserDTO> users = userServices.getUsersByRole(role, pageable);
        return ResponseEntity.ok(users);
    }

    // Students can assign payments to their account
    @PostMapping("/{userId}/paiement")
    public ResponseEntity<UserDTO> assignToPaiement(@PathVariable long userId, @RequestBody PaiementDTO paiementDTO) {
        try {
            UserDTO userDTO = userServices.assignPaiementToUser(userId, paiementDTO);
            return ResponseEntity.ok(userDTO);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Students can add blogs to their account
    @PostMapping("/{userId}/blog")
    public ResponseEntity<UserDTO> assignToBlog(@PathVariable long userId, @RequestBody BlogDTO blogDTO) {
        try {
            UserDTO userDTO = userServices.assignBlogToUser(userId, blogDTO);
            return ResponseEntity.ok(userDTO);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
