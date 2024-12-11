package com.jo_paris_2024.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Stade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_stade;
    private String nom_stade;
    private String adresse_stade;

    // Constructeur par défaut
    public Stade() {}

    // Constructeur avec arguments
    public Stade(Long id_stade, String nom_stade, String adresse_stade) {
        this.id_stade = id_stade;
        this.nom_stade = nom_stade;
        this.adresse_stade = adresse_stade;
    }

    // Getters et Setters
    public Long getId_stade() {
        return id_stade;
    }

    public void setId_stade(Long id_stade) {
        this.id_stade = id_stade;
    }

    public String getNom_stade() {
        return nom_stade;
    }

    public void setNom_stade(String nom_stade) {
        this.nom_stade = nom_stade;
    }

    public String getAdresse_stade() {
        return adresse_stade;
    }

    public void setAdresse_stade(String adresse_stade) {
        this.adresse_stade = adresse_stade;
    }
}
