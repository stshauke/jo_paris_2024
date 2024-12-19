package com.jo_paris_2024.dto;

import java.math.BigDecimal;

/**
 * Classe DTO représentant un visiteur.
 */
public class VisiteurDTO {

    // Identifiant unique du visiteur
    private Long idVisiteur;

    // Nom du visiteur
    private String nomVisiteur;

    // Prénom du visiteur
    private String prenomVisiteur;

    // Email du visiteur
    private String emailVisiteur;

    // Mot de passe du visiteur (hashé si possible)
    private String passwordVisiteur;

    // Solde du visiteur
    private BigDecimal soldeVisiteur;

    // Clé unique du visiteur (optionnelle, à préciser)
    private String cleVisiteur;

    // Constructeur sans arguments
    public VisiteurDTO() {
    }

    // Constructeur avec arguments
    public VisiteurDTO(Long idVisiteur, String nomVisiteur, String prenomVisiteur,
                       String emailVisiteur, String passwordVisiteur, BigDecimal soldeVisiteur,
                       String cleVisiteur) {
        this.idVisiteur = idVisiteur;
        this.nomVisiteur = nomVisiteur;
        this.prenomVisiteur = prenomVisiteur;
        this.emailVisiteur = emailVisiteur;
        this.passwordVisiteur = passwordVisiteur;
        this.soldeVisiteur = soldeVisiteur;
        this.cleVisiteur = cleVisiteur;
    }

    // Getters et Setters

    public Long getIdVisiteur() {
        return idVisiteur;
    }

    public void setIdVisiteur(Long idVisiteur) {
        this.idVisiteur = idVisiteur;
    }

    public String getNomVisiteur() {
        return nomVisiteur;
    }

    public void setNomVisiteur(String nomVisiteur) {
        this.nomVisiteur = nomVisiteur;
    }

    public String getPrenomVisiteur() {
        return prenomVisiteur;
    }

    public void setPrenomVisiteur(String prenomVisiteur) {
        this.prenomVisiteur = prenomVisiteur;
    }

    public String getEmailVisiteur() {
        return emailVisiteur;
    }

    public void setEmailVisiteur(String emailVisiteur) {
        if (emailVisiteur != null && emailVisiteur.contains("@")) {
            this.emailVisiteur = emailVisiteur;
        } else {
            throw new IllegalArgumentException("Email invalide.");
        }
    }

    public String getPasswordVisiteur() {
        return passwordVisiteur;
    }

    public void setPasswordVisiteur(String passwordVisiteur) {
        if (passwordVisiteur != null && passwordVisiteur.length() >= 8) {
            this.passwordVisiteur = passwordVisiteur;
        } else {
            throw new IllegalArgumentException("Le mot de passe doit contenir au moins 8 caractères.");
        }
    }

    public BigDecimal getSoldeVisiteur() {
        return soldeVisiteur;
    }

    public void setSoldeVisiteur(BigDecimal soldeVisiteur) {
        if (soldeVisiteur != null && soldeVisiteur.compareTo(BigDecimal.ZERO) >= 0) {
            this.soldeVisiteur = soldeVisiteur;
        } else {
            throw new IllegalArgumentException("Le solde ne peut pas être négatif.");
        }
    }

    public String getCleVisiteur() {
        return cleVisiteur;
    }

    public void setCleVisiteur(String cleVisiteur) {
        this.cleVisiteur = cleVisiteur;
    }

    // Méthode toString sécurisée
    @Override
    public String toString() {
        return "VisiteurDTO{" +
                "idVisiteur=" + idVisiteur +
                ", nomVisiteur='" + nomVisiteur + '\'' +
                ", prenomVisiteur='" + prenomVisiteur + '\'' +
                ", emailVisiteur='" + emailVisiteur + '\'' +
                ", soldeVisiteur=" + soldeVisiteur +
                ", cleVisiteur='" + cleVisiteur + '\'' +
                '}';
    }
}
