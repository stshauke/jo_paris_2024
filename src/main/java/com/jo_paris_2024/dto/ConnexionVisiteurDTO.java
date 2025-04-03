package com.jo_paris_2024.dto;

/**
 * DTO (Data Transfer Object) utilisé pour la connexion d'un visiteur.
 * Cette classe est responsable du transfert des données de connexion (email et mot de passe)
 * entre la couche de présentation (frontend) et la couche de service (backend).
 */
public class ConnexionVisiteurDTO {

    // Adresse e-mail du visiteur utilisée pour l'authentification
    private String email;

    // Mot de passe du visiteur utilisé pour l'authentification
    private String password;

    /**
     * Récupère l'adresse e-mail du visiteur.
     * 
     * @return L'email du visiteur.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Définit l'adresse e-mail du visiteur.
     * 
     * @param email L'adresse e-mail à enregistrer.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Récupère le mot de passe du visiteur.
     * 
     * @return Le mot de passe du visiteur.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Définit le mot de passe du visiteur.
     * 
     * @param password Le mot de passe à enregistrer.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
