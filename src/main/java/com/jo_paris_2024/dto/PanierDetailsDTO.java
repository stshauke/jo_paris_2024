package com.jo_paris_2024.dto;

// DTO (Data Transfer Object) pour représenter les détails d'un panier
public class PanierDetailsDTO {
    // Identifiant unique du panier
    private Long idPanier;
    // Identifiant unique du visiteur associé au panier
    private Long idVisiteur;
    // Nom du visiteur
    private String nomVisiteur;
    // Email du visiteur
    private String emailVisiteur;
    // Identifiant unique du billet dans le panier
    private Long idBillet;
    // Nom ou description du billet
    private String nomBillet;
    // Quantité de billets dans le panier
    private Integer quantite;
    // Prix unitaire du billet
    private Double prix;

    // Constructeur complet permettant d'initialiser tous les champs de la classe
    public PanierDetailsDTO(Long idPanier, Long idVisiteur, String nomVisiteur,
                            String emailVisiteur, Long idBillet, String nomBillet,
                            Integer quantite, Double prix) {
        this.idPanier = idPanier;
        this.idVisiteur = idVisiteur;
        this.nomVisiteur = nomVisiteur;
        this.emailVisiteur = emailVisiteur;
        this.idBillet = idBillet;
        this.nomBillet = nomBillet;
        this.quantite = quantite;
        this.prix = prix;
    }

    // Getter pour l'identifiant du panier
    public Long getIdPanier() {
        return idPanier;
    }

    // Setter pour l'identifiant du panier
    public void setIdPanier(Long idPanier) {
        this.idPanier = idPanier;
    }

    // Getter pour l'identifiant du visiteur
    public Long getIdVisiteur() {
        return idVisiteur;
    }

    // Setter pour l'identifiant du visiteur
    public void setIdVisiteur(Long idVisiteur) {
        this.idVisiteur = idVisiteur;
    }

    // Getter pour le nom du visiteur
    public String getNomVisiteur() {
        return nomVisiteur;
    }

    // Setter pour le nom du visiteur
    public void setNomVisiteur(String nomVisiteur) {
        this.nomVisiteur = nomVisiteur;
    }

    // Getter pour l'email du visiteur
    public String getEmailVisiteur() {
        return emailVisiteur;
    }

    // Setter pour l'email du visiteur
    public void setEmailVisiteur(String emailVisiteur) {
        this.emailVisiteur = emailVisiteur;
    }

    // Getter pour l'identifiant du billet
    public Long getIdBillet() {
        return idBillet;
    }

    // Setter pour l'identifiant du billet
    public void setIdBillet(Long idBillet) {
        this.idBillet = idBillet;
    }

    // Getter pour le nom du billet
    public String getNomBillet() {
        return nomBillet;
    }

    // Setter pour le nom du billet
    public void setNomBillet(String nomBillet) {
        this.nomBillet = nomBillet;
    }

    // Getter pour la quantité de billets
    public Integer getQuantite() {
        return quantite;
    }

    // Setter pour la quantité de billets
    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    // Getter pour le prix du billet
    public Double getPrix() {
        return prix;
    }

    // Setter pour le prix du billet
    public void setPrix(Double prix) {
        this.prix = prix;
    }

    // Méthode toString() pour faciliter le débogage et l'affichage des données de l'objet
    @Override
    public String toString() {
        return "PanierDetailsDTO{" +
                "idPanier=" + idPanier +
                ", idVisiteur=" + idVisiteur +
                ", nomVisiteur='" + nomVisiteur + '\'' +
                ", emailVisiteur='" + emailVisiteur + '\'' +
                ", idBillet=" + idBillet +
                ", nomBillet='" + nomBillet + '\'' +
                ", quantite=" + quantite +
                ", prix=" + prix +
                '}';
    }
}
