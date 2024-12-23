package com.jo_paris_2024.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Billet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_billet;

    @Column(nullable = false)
    private int id_offre; // ID de l'offre associée

    @Column(nullable = false, length = 50)
    private String type_billet; // Type de billet (ex: VIP, Standard)

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal prix_billet; // Prix du billet

    @Column(nullable = false)
    private int stock; // Quantité disponible

    // Constructeur par défaut
    public Billet() {}

    // Constructeur avec arguments
    public Billet(Long id_billet, int id_offre, String type_billet, BigDecimal prix_billet, int stock) {
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
}
