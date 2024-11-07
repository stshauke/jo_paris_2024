package com.jo_paris_2024.dto;

public class StadeDTO {

	private Long id_stade;
    private String nom_stade;
    private String adresse_stade;

    // Constructeur sans arguments
    public StadeDTO() {
    }

    // Constructeur avec tous les arguments
    public StadeDTO(Long id_stade, String nom_stade, String adresse_stade) {
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

    // Méthode toString pour afficher les informations du stade
    @Override
    public String toString() {
        return "StadeDTO{" +
                "id_stade=" + id_stade +
                ", nom_stade='" + nom_stade + '\'' +
                ", adresse_stade='" + adresse_stade + '\'' +
                '}';
    }
}
