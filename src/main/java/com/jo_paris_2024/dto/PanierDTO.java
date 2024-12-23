package com.jo_paris_2024.dto;

import java.time.LocalDateTime;

/**
 * Classe DTO représentant un panier.
 */
public class PanierDTO {

    // Identifiant unique du panier
    private Integer idPanier;

    // Identifiant du visiteur
    private Integer idVisiteur;

    // Identifiant du billet
    private Integer idBillet;

    // Quantité de billets dans le panier
    private Integer quantite;

    // Date d'ajout du billet au panier
    private LocalDateTime dateAjout;

    // Constructeur sans arguments
    public PanierDTO() {
    }

    // Constructeur avec arguments
    public PanierDTO(Integer idPanier, Integer idVisiteur, Integer idBillet, Integer quantite, LocalDateTime dateAjout) {
        this.idPanier = idPanier;
        this.idVisiteur = idVisiteur;
        this.idBillet = idBillet;
        this.quantite = quantite;
        this.dateAjout = dateAjout;
    }

    // Getters et Setters

    public Integer getIdPanier() {
        return idPanier;
    }

    public void setIdPanier(Integer idPanier) {
        this.idPanier = idPanier;
    }

    public Integer getIdVisiteur() {
        return idVisiteur;
    }

    public void setIdVisiteur(Integer idVisiteur) {
        this.idVisiteur = idVisiteur;
    }

    public Integer getIdBillet() {
        return idBillet;
    }

    public void setIdBillet(Integer idBillet) {
        this.idBillet = idBillet;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        if (quantite != null && quantite > 0) {
            this.quantite = quantite;
        } else {
            throw new IllegalArgumentException("La quantité doit être supérieure à zéro.");
        }
    }

    public LocalDateTime getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(LocalDateTime dateAjout) {
        this.dateAjout = dateAjout;
    }

    // Méthode toString
    @Override
    public String toString() {
        return "PanierDTO{" +
                "idPanier=" + idPanier +
                ", idVisiteur=" + idVisiteur +
                ", idBillet=" + idBillet +
                ", quantite=" + quantite +
                ", dateAjout=" + dateAjout +
                '}';
    }
}
