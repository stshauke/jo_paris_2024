package com.jo_paris_2024.dto;

import java.math.BigDecimal;

/**
 * DTO (Data Transfer Object) pour représenter un billet.
 * Cette classe est utilisée pour transférer des données entre les différentes couches de l'application.
 */
public class BilletDTO {

    private Long id_billet; // Identifiant unique du billet
    private int id_offre; // Identifiant de l'offre associée au billet
    private String type_billet; // Type du billet (ex: "VIP", "Standard", etc.)
    private BigDecimal prix_billet; // Prix du billet
    private int stock; // Nombre de billets disponibles en stock

    /**
     * Constructeur par défaut (nécessaire pour la sérialisation/désérialisation).
     */
    public BilletDTO() {
    }

    /**
     * Constructeur avec paramètres pour initialiser un billet avec des valeurs spécifiques.
     *
     * @param id_billet   Identifiant unique du billet
     * @param id_offre    Identifiant de l'offre associée
     * @param type_billet Type du billet (VIP, Standard, etc.)
     * @param prix_billet Prix du billet
     * @param stock      Nombre de billets disponibles
     */
    public BilletDTO(Long id_billet, int id_offre, String type_billet, BigDecimal prix_billet, int stock) {
        this.id_billet = id_billet;
        this.id_offre = id_offre;
        this.type_billet = type_billet;
        this.prix_billet = prix_billet;
        this.stock = stock;
    }

    // Getters et Setters

    /**
     * Récupère l'identifiant du billet.
     * @return id_billet
     */
    public Long getId_billet() {
        return id_billet;
    }

    /**
     * Définit l'identifiant du billet.
     * @param id_billet Nouvel identifiant du billet
     */
    public void setId_billet(Long id_billet) {
        this.id_billet = id_billet;
    }

    /**
     * Récupère l'identifiant de l'offre associée.
     * @return id_offre
     */
    public int getId_offre() {
        return id_offre;
    }

    /**
     * Définit l'identifiant de l'offre associée.
     * @param id_offre Nouvel identifiant de l'offre
     */
    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }

    /**
     * Récupère le type du billet.
     * @return type_billet
     */
    public String getType_billet() {
        return type_billet;
    }

    /**
     * Définit le type du billet.
     * @param type_billet Nouveau type de billet (ex: VIP, Standard)
     */
    public void setType_billet(String type_billet) {
        this.type_billet = type_billet;
    }

    /**
     * Récupère le prix du billet.
     * @return prix_billet
     */
    public BigDecimal getPrix_billet() {
        return prix_billet;
    }

    /**
     * Définit le prix du billet.
     * @param prix_billet Nouveau prix du billet
     */
    public void setPrix_billet(BigDecimal prix_billet) {
        this.prix_billet = prix_billet;
    }

    /**
     * Récupère le nombre de billets disponibles.
     * @return stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * Définit le nombre de billets disponibles.
     * @param stock Nouveau stock de billets
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Retourne une représentation textuelle de l'objet BilletDTO.
     * @return Chaîne contenant les informations du billet
     */
    @Override
    public String toString() {
        return "BilletDTO{" +
                "id_billet=" + id_billet +
                ", id_offre=" + id_offre +
                ", type_billet='" + type_billet + '\'' +
                ", prix_billet=" + prix_billet +
                ", stock=" + stock +
                '}';
    }
}
