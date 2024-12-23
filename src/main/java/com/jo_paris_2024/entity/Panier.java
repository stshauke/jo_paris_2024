package com.jo_paris_2024.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Panier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_panier;
    private Integer id_visiteur;
    private Integer id_billet;
    private Integer quantite;
    private LocalDateTime date_ajout;

    // Constructeur par défaut
    public Panier() {}

    // Constructeur avec arguments
    public Panier(Integer id_panier, Integer id_visiteur, Integer id_billet, Integer quantite, LocalDateTime date_ajout) {
        this.id_panier = id_panier;
        this.id_visiteur = id_visiteur;
        this.id_billet = id_billet;
        this.quantite = quantite;
        this.date_ajout = date_ajout;
    }

    // Getters et Setters
    public Integer getId_panier() {
        return id_panier;
    }

    public void setId_panier(Integer id_panier) {
        this.id_panier = id_panier;
    }

    public Integer getId_visiteur() {
        return id_visiteur;
    }

    public void setId_visiteur(Integer id_visiteur) {
        this.id_visiteur = id_visiteur;
    }

    public Integer getId_billet() {
        return id_billet;
    }

    public void setId_billet(Integer id_billet) {
        this.id_billet = id_billet;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public LocalDateTime getDate_ajout() {
        return date_ajout;
    }

    public void setDate_ajout(LocalDateTime date_ajout) {
        this.date_ajout = date_ajout;
    }
}
