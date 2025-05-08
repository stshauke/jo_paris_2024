package com.jo_paris_2024.dto;

import java.util.List;
import java.util.Map;

public class PaiementRequestDTO {

    private int idVisiteur;          // pour /simuler
    private double montant;          // pour /simuler

    private String email;            // pour /cache-session
    private List<Map<String, Object>> billets; // pour /cache-session

    // Getters et Setters pour /simuler
    public int getIdVisiteur() {
        return idVisiteur;
    }

    public void setIdVisiteur(int idVisiteur) {
        this.idVisiteur = idVisiteur;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    // Getters et Setters pour /cache-session
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Map<String, Object>> getBillets() {
        return billets;
    }

    public void setBillets(List<Map<String, Object>> billets) {
        this.billets = billets;
    }
}
