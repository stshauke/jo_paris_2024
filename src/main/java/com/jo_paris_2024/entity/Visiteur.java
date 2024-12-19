package com.jo_paris_2024.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "visiteur")
public class Visiteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_visiteur;

    private String nom_visiteur;
    private String prenom_visiteur;
    @Column(name = "email_visiteur", unique = true)
    private String emailVisiteur;
    private String password_visiteur;
    private BigDecimal solde_visiteur;
    private String cle_visiteur;

    // Constructeur sans arguments
    public Visiteur() {
    }

    // Constructeur avec tous les arguments
    public Visiteur(Long id_visiteur, String nom_visiteur, String prenom_visiteur, 
                    String email_visiteur, String password_visiteur, BigDecimal solde_visiteur,
                    String cle_visiteur) {
        this.id_visiteur = id_visiteur;
        this.nom_visiteur = nom_visiteur;
        this.prenom_visiteur = prenom_visiteur;
        this.emailVisiteur = email_visiteur;
        this.password_visiteur = password_visiteur;
        this.solde_visiteur = solde_visiteur;
        this.cle_visiteur = cle_visiteur;
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
        return emailVisiteur;
    }

    public void setEmail_visiteur(String email_visiteur) {
        this.emailVisiteur = email_visiteur;
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

    public String getCle_visiteur() {
        return cle_visiteur;
    }

    public void setCle_visiteur(String cle_visiteur) {
        this.cle_visiteur = cle_visiteur;
    }
}