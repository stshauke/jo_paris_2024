package com.jo_paris_2024.entity;

// Import des annotations JPA nécessaires pour définir une entité
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Annotation qui indique que cette classe est une entité JPA (persistée dans la base de données)
@Entity
public class Stade {

    // Annotation qui précise que ce champ est la clé primaire de l'entité
    @Id
    // Annotation qui indique que la valeur est générée automatiquement par la base de données
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_stade; // Identifiant unique du stade

    private String nom_stade; // Nom du stade
    private String adresse_stade; // Adresse du stade

    // Constructeur par défaut requis par JPA
    public Stade() {}

    // Constructeur avec arguments pour initialiser tous les champs
    public Stade(Long id_stade, String nom_stade, String adresse_stade) {
        this.id_stade = id_stade;
        this.nom_stade = nom_stade;
        this.adresse_stade = adresse_stade;
    }

    // Getter pour l'identifiant du stade
    public Long getId_stade() {
        return id_stade;
    }

    // Setter pour l'identifiant du stade
    public void setId_stade(Long id_stade) {
        this.id_stade = id_stade;
    }

    // Getter pour le nom du stade
    public String getNom_stade() {
        return nom_stade;
    }

    // Setter pour le nom du stade
    public void setNom_stade(String nom_stade) {
        this.nom_stade = nom_stade;
    }

    // Getter pour l'adresse du stade
    public String getAdresse_stade() {
        return adresse_stade;
    }

    // Setter pour l'adresse du stade
    public void setAdresse_stade(String adresse_stade) {
        this.adresse_stade = adresse_stade;
    }
}
