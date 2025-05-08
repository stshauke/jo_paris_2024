package com.jo_paris_2024.entity;

// Import des annotations JPA pour la persistance
import jakarta.persistence.*;
import java.math.BigDecimal; // Import pour gérer des montants financiers avec précision

// Annotation qui indique que cette classe est une entité JPA
@Entity
// Annotation pour spécifier le nom de la table associée à cette entité
@Table(name = "visiteur")
public class Visiteur {

    // Clé primaire de l'entité avec auto-incrément
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_visiteur;

    // Nom du visiteur
    private String nom_visiteur;

    // Prénom du visiteur
    private String prenom_visiteur;

    // Email du visiteur avec contrainte d'unicité dans la base
    @Column(name = "email_visiteur", unique = true)
    private String emailVisiteur;

    // Mot de passe du visiteur
    private String password_visiteur;

    // Solde du visiteur, représenté en BigDecimal pour éviter les erreurs de précision
    private BigDecimal solde_visiteur;

    // Clé de sécurité ou identifiant supplémentaire du visiteur
    private String cle_visiteur;

    // Constructeur sans arguments (obligatoire pour JPA)
    public Visiteur() {
    }

    // Constructeur avec tous les arguments pour créer un visiteur complet
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

    // Getter pour l'id du visiteur
    public Long getId_visiteur() {
        return id_visiteur;
    }

    // Setter pour l'id du visiteur
    public void setId_visiteur(Long id_visiteur) {
        this.id_visiteur = id_visiteur;
    }

    // Getter pour le nom du visiteur
    public String getNom_visiteur() {
        return nom_visiteur;
    }

    // Setter pour le nom du visiteur
    public void setNom_visiteur(String nom_visiteur) {
        this.nom_visiteur = nom_visiteur;
    }

    // Getter pour le prénom du visiteur
    public String getPrenom_visiteur() {
        return prenom_visiteur;
    }

    // Setter pour le prénom du visiteur
    public void setPrenom_visiteur(String prenom_visiteur) {
        this.prenom_visiteur = prenom_visiteur;
    }

    // Getter pour l'email du visiteur
    public String getEmailVisiteur() {
        return emailVisiteur;
    }

    public void setEmailVisiteur(String emailVisiteur) {
        this.emailVisiteur = emailVisiteur;
    }

    // Getter pour le mot de passe du visiteur
    public String getPassword_visiteur() {
        return password_visiteur;
    }

    // Setter pour le mot de passe du visiteur
    public void setPassword_visiteur(String password_visiteur) {
        this.password_visiteur = password_visiteur;
    }

    // Getter pour le solde du visiteur
    public BigDecimal getSolde_visiteur() {
        return solde_visiteur;
    }

    // Setter pour le solde du visiteur
    public void setSolde_visiteur(BigDecimal solde_visiteur) {
        this.solde_visiteur = solde_visiteur;
    }

    // Getter pour la clé du visiteur
    public String getCle_visiteur() {
        return cle_visiteur;
    }

    // Setter pour la clé du visiteur
    public void setCle_visiteur(String cle_visiteur) {
        this.cle_visiteur = cle_visiteur;
    }
}
