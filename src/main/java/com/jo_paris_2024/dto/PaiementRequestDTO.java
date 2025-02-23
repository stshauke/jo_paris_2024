package com.jo_paris_2024.dto;

public class PaiementRequestDTO {

    private int idVisiteur;
    private double montant;

    // Getter pour idVisiteur
    public int getIdVisiteur() {
        return idVisiteur;
    }

    // Setter pour idVisiteur
    public void setIdVisiteur(int idVisiteur) {
        this.idVisiteur = idVisiteur;
    }

    // Getter pour montant
    public double getMontant() {
        return montant;
    }

    // Setter pour montant
    public void setMontant(double montant) {
        this.montant = montant;
    }
}
