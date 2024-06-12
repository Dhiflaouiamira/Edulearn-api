package com.tekup.EduLearnapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tekup.EduLearnapi.Service.JwtService;
import com.tekup.EduLearnapi.Service.UserServices;
import com.tekup.EduLearnapi.dto.UserDTO;
import com.tekup.EduLearnapi.model.AuthRequest;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {

	  @Autowired
	    private AuthenticationManager authenticationManager;
	    @Autowired
	    private JwtService jwtService;
	    @Autowired
	    private final UserServices userServices;

	      
	    
	    @GetMapping("/welcome")
	    public ResponseEntity<String> welcome(){
	        return ResponseEntity.ok("Welcome to Edulearn !!");
	    }
	    
	    
	    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest authRequest){
        try {
            Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
            if(authenticate.isAuthenticated()){
                return ResponseEntity.ok(jwtService.generateToken(authRequest.getUserName()));
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
            userServices.addOneUser(userDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User registration failed: " + e.getMessage());
        }
    }
}
