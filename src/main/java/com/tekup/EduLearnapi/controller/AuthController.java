package com.tekup.EduLearnapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tekup.EduLearnapi.Service.JwtService;
import com.tekup.EduLearnapi.Service.UserServices;
import com.tekup.EduLearnapi.dto.UserDTO;
import com.tekup.EduLearnapi.model.AuthRequest;
import com.tekup.EduLearnapi.model.AuthResponse;
import com.tekup.EduLearnapi.model.User;
import com.tekup.EduLearnapi.repository.UserRepository;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserServices userServices;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        try {
            Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));

            if (authenticate.isAuthenticated()) {
                String token = jwtService.generateToken(authRequest.getUserName());

                // Fetch user details
                User user = userRepository.findByNom(authRequest.getUserName())
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));

                // Create response with all user details including the ID
                AuthResponse authResponse = new AuthResponse(
                    token,
                    user.getRole(),
                    user.getImage(), // Assuming this field is in the User class
                    user.getNom(), // Assuming getter for name
                    user.getEmail(), // Assuming getter for email
                    user.getTelephone(), // Assuming getter for telephone
                    user.getId() // Include the ID field
                );

                return ResponseEntity.ok(authResponse);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            }
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid user request");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDTO userDTO) {
        try {
            // Set the role to "student"
            userDTO.setRole("STUDENT");

            // Add the user with the specified role
            userServices.addOneUser(userDTO);

            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User registration failed: " + e.getMessage());
        }
    }
}
