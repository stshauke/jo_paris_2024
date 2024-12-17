package com.jo_paris_2024.dto;

import java.math.BigDecimal;

public class VisiteurDTO {
	private Long id_visiteur;
    private String nom_visiteur;
    private String prenom_visiteur;
    private String email_visiteur;
    private String password_visiteur;
    private BigDecimal solde_visiteur;

    // Constructeur sans arguments
    public VisiteurDTO() {
    }
 // Constructeur avec arguments
    public VisiteurDTO(Long id_visiteur, String nom_visiteur, String prenom_visiteur, 
    		String email_visiteur, String password_visiteur, BigDecimal solde_visiteur) {
        this.id_visiteur = id_visiteur;
        this.nom_visiteur = nom_visiteur;
        this.prenom_visiteur = prenom_visiteur;
        this.email_visiteur = email_visiteur;
        this.password_visiteur = password_visiteur;
        this.solde_visiteur = solde_visiteur;
    }
    
 // Getters et Setters
    public Long getId_visiteur() {
        return id_visiteur;
    }

    public void setId_visiteur(Long id_visiteur) {
        this.id_visiteur = id_visiteur;
    }

    public String getNom_visiteur() {
        return nom_visiteur;
    }

    public void setNom_visiteur(String nom_visiteur) {
        this.nom_visiteur = nom_visiteur;
    }

    public String getPrenom_visiteur() {
        return prenom_visiteur;
    }

    public void setPrenom_visiteur(String prenom_visiteur) {
        this.prenom_visiteur = prenom_visiteur;
    }

    public String getEmail_visiteur() {
        return email_visiteur;
    }

    public void setEmail_visiteur(String email_visiteur) {
        this.email_visiteur = email_visiteur;
    }

    public String getPassword_visiteur() {
        return password_visiteur;
    }

    public void setPassword_visiteur(String password_visiteur) {
        this.password_visiteur = password_visiteur;
    }

    public BigDecimal getSolde_visiteur() {
        return solde_visiteur;
    }

    public void setSolde_visiteur(BigDecimal solde_visiteur) {
        this.solde_visiteur = solde_visiteur;
    }
    
 // Méthode toString pour afficher les informations du stade
    @Override
    public String toString() {
        return "VisiteurDTO{" +
        "id_visiteur=" + id_visiteur+
        ", nom_visiteur=" + nom_visiteur + '\'' +
       ", prenom_visiteur=" + prenom_visiteur + '\'' +
        ", email_visiteur=" + email_visiteur + '\'' +
        ", solde_visiteur=" + solde_visiteur + '\'' +
        '}';
        
    }
}
