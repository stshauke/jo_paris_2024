package com.jo_paris_2024.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO (Data Transfer Object) utilisé pour transférer les informations d'une offre.
 * Cette classe contient les attributs liés à une offre spécifique, comme son identifiant,
 * son nom, sa description, son prix, le nombre de personnes qu'elle peut accueillir,
 * et la date de fin de validité de l'offre.
 */
public class OffreDTO {

    // Identifiant unique de l'offre (généralement utilisé pour l'identification de l'offre dans la base de données)
    private Long id_offre;

    // Nom de l'offre, décrit brièvement le type de l'offre
    private String nom_offre;

    // Description détaillée de l'offre, expliquant les caractéristiques, avantages, etc.
    private String description_offre;

    // Prix de l'offre, utilisé pour indiquer combien coûte l'offre
    private BigDecimal prix_offre;

    // Nombre maximal de personnes pouvant profiter de l'offre
    private Long nombre_personnes;

    // Date de fin de l'offre, indiquant jusqu'à quand l'offre est valable
    private LocalDate date_fin_offre;

    /**
     * Constructeur sans arguments, utilisé pour créer un objet OffreDTO vide.
     */
    public OffreDTO() {
    }

    /**
     * Constructeur avec tous les arguments pour initialiser une offre avec toutes ses propriétés.
     *
     * @param id_offre L'identifiant unique de l'offre.
     * @param nom_offre Le nom de l'offre.
     * @param description_offre La description détaillée de l'offre.
     * @param prix_offre Le prix de l'offre.
     * @param nombre_personnes Le nombre maximum de personnes pouvant profiter de l'offre.
     * @param date_fin_offre La date de fin de l'offre.
     */
    public OffreDTO(Long id_offre, String nom_offre, String description_offre, 
                    BigDecimal prix_offre, Long nombre_personnes, LocalDate date_fin_offre) {
        this.id_offre = id_offre;
        this.nom_offre = nom_offre;
        this.description_offre = description_offre;
        this.prix_offre = prix_offre;
        this.nombre_personnes = nombre_personnes;
        this.date_fin_offre = date_fin_offre;
    }

    // **Getters et Setters** : Ces méthodes sont utilisées pour accéder et modifier les propriétés de l'objet.
    public Long getId_offre() {
        return id_offre;
    }

    public void setId_offre(Long id_offre) {
        this.id_offre = id_offre;
    }

    public String getNom_offre() {
        return nom_offre;
    }

    public void setNom_offre(String nom_offre) {
        this.nom_offre = nom_offre;
    }

    public String getDescription_offre() {
        return description_offre;
    }

    public void setDescription_offre(String description_offre) {
        this.description_offre = description_offre;
    }

    public BigDecimal getPrix_offre() {
        return prix_offre;
    }

    public void setPrix_offre(BigDecimal prix_offre) {
        this.prix_offre = prix_offre;
    }

    public Long getNombre_personnes() {
        return nombre_personnes;
    }

    public void setNombre_personnes(Long nombre_personnes) {
        this.nombre_personnes = nombre_personnes;
    }

    public LocalDate getDate_fin_offre() {
        return date_fin_offre;
    }

    public void setDate_fin_offre(LocalDate date_fin_offre) {
        this.date_fin_offre = date_fin_offre;
    }

    /**
     * Méthode `toString()` pour afficher les informations détaillées de l'offre sous forme de chaîne.
     * Cela est utile pour les logs, débogage ou affichage d'informations simples.
     *
     * @return Une chaîne formatée contenant toutes les informations de l'offre.
     */
    @Override
    public String toString() {
        return "OffreDTO{" +
                "id_offre=" + id_offre +
                ", nom_offre='" + nom_offre + '\'' +
                ", description_offre='" + description_offre + '\'' +
                ", prix_offre=" + prix_offre +
                ", nombre_personnes=" + nombre_personnes +
                ", date_fin_offre=" + date_fin_offre +
                '}';
    }
}
