package com.tekup.EduLearnapi.model;

public class AuthResponse {
    private String token;
    private String role;
    private String image;
    private String nom;
    private String email;
    private double telephone;
    private Long id; // Added id field

    // Updated constructor
    public AuthResponse(String token, String role, String image, String nom, String email, double telephone, Long id) {
        this.token = token;
        this.role = role;
        this.image = image;
        this.nom = nom;
        this.email = email;
        this.telephone = telephone;
        this.id = id; // Initialize id field
    }

    // Getters and setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getTelephone() {
        return telephone;
    }

    public void setTelephone(double telephone) {
        this.telephone = telephone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
