package com.jo_paris_2024.dto;

/**
 * DTO (Data Transfer Object) utilisé pour encapsuler la réponse lors de la connexion d'un utilisateur.
 * Cette classe est retournée après une authentification réussie et contient le jeton d'accès (JWT),
 * l'adresse e-mail de l'utilisateur et son nom.
 */
public class LoginResponse {

    // Jeton JWT généré après l'authentification réussie
    private String token;

    // Adresse e-mail de l'utilisateur connecté
    private String email;

    // Nom de l'utilisateur connecté
    private String nom;

    /**
     * Constructeur de la classe LoginResponse.
     * 
     * @param token Le jeton d'authentification JWT.
     * @param email L'adresse e-mail de l'utilisateur.
     * @param nom Le nom de l'utilisateur.
     */
    public LoginResponse(String token, String email, String nom) {
        this.token = token;
        this.email = email;
        this.nom = nom;
    }

    /**
     * Récupère le jeton JWT.
     * 
     * @return Le jeton JWT.
     */
    public String getToken() {
        return token;
    }

    /**
     * Définit le jeton JWT.
     * 
     * @param token Le jeton à enregistrer.
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Récupère l'adresse e-mail de l'utilisateur.
     * 
     * @return L'adresse e-mail de l'utilisateur.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Définit l'adresse e-mail de l'utilisateur.
     * 
     * @param email L'adresse e-mail à enregistrer.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Récupère le nom de l'utilisateur.
     * 
     * @return Le nom de l'utilisateur.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom de l'utilisateur.
     * 
     * @param nom Le nom à enregistrer.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
}
