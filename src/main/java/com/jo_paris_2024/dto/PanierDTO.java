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

    // Identifiant unique du billet acheté
    private String identifiantBillet;

    // Date d'ajout du billet au panier
    private LocalDateTime dateAjout;

    // Constructeur sans arguments
    public PanierDTO() {
        // Initialisation de la date à l'heure actuelle si aucune valeur n'est fournie
        this.dateAjout = LocalDateTime.now();
    }

    // Constructeur avec arguments
    public PanierDTO(Integer idPanier, Integer idVisiteur, Integer idBillet, String identifiantBillet, LocalDateTime dateAjout) {
        this.idPanier = idPanier;
        this.idVisiteur = idVisiteur;
        this.idBillet = idBillet;
        this.identifiantBillet = identifiantBillet;
        this.dateAjout = dateAjout != null ? dateAjout : LocalDateTime.now(); // Si la date est nulle, on utilise l'heure actuelle
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

    public String getIdentifiantBillet() {
        return identifiantBillet;
    }

    public void setIdentifiantBillet(String identifiantBillet) {
        this.identifiantBillet = identifiantBillet;
    }

    public LocalDateTime getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(LocalDateTime dateAjout) {
        if (dateAjout != null) {
            this.dateAjout = dateAjout;
        } else {
            throw new IllegalArgumentException("La date d'ajout ne peut pas être nulle.");
        }
    }

    // Méthode toString
    @Override
    public String toString() {
        return "PanierDTO{" +
                "idPanier=" + idPanier +
                ", idVisiteur=" + idVisiteur +
                ", idBillet=" + idBillet +
                ", identifiantBillet='" + identifiantBillet + '\'' +
                ", dateAjout=" + dateAjout +
                '}';
    }
}
