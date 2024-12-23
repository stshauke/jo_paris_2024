package com.jo_paris_2024.dto;

import java.math.BigDecimal;

public class BilletDTO {

    private Long id_billet;
    private int id_offre;
    private String type_billet;
    private BigDecimal prix_billet;
    private int stock;

    // Constructeur sans arguments
    public BilletDTO() {
    }

    // Constructeur avec tous les arguments
    public BilletDTO(Long id_billet, int id_offre, String type_billet, BigDecimal prix_billet, int stock) {
        this.id_billet = id_billet;
        this.id_offre = id_offre;
        this.type_billet = type_billet;
        this.prix_billet = prix_billet;
        this.stock = stock;
    }

    // Getters et Setters
    public Long getId_billet() {
        return id_billet;
    }

    public void setId_billet(Long id_billet) {
        this.id_billet = id_billet;
    }

    public int getId_offre() {
        return id_offre;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }

    public String getType_billet() {
        return type_billet;
    }

    public void setType_billet(String type_billet) {
        this.type_billet = type_billet;
    }

    public BigDecimal getPrix_billet() {
        return prix_billet;
    }

    public void setPrix_billet(BigDecimal prix_billet) {
        this.prix_billet = prix_billet;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // Méthode toString pour afficher les informations du billet
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
