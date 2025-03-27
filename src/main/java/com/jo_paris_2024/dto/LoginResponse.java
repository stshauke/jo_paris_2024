package com.jo_paris_2024.dto;

public class LoginResponse {
    private String token;
    private String email;
    private String nom;

    public LoginResponse(String token, String email, String nom) {
        this.token = token;
        this.email = email;
        this.nom = nom;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
