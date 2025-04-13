package com.jo_paris_2024.dto;

public class PanierDetailsDTO {
    private Long idPanier;
    private Long idVisiteur;
    private String nomVisiteur;
    private String emailVisiteur;
    private Long idBillet;
    private String nomBillet;
    private Integer quantite;
    private Double prix;

    // Constructeur complet
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

    // Getters et Setters

    public Long getIdPanier() {
        return idPanier;
    }

    public void setIdPanier(Long idPanier) {
        this.idPanier = idPanier;
    }

    public Long getIdVisiteur() {
        return idVisiteur;
    }

    public void setIdVisiteur(Long idVisiteur) {
        this.idVisiteur = idVisiteur;
    }

    public String getNomVisiteur() {
        return nomVisiteur;
    }

    public void setNomVisiteur(String nomVisiteur) {
        this.nomVisiteur = nomVisiteur;
    }

    public String getEmailVisiteur() {
        return emailVisiteur;
    }

    public void setEmailVisiteur(String emailVisiteur) {
        this.emailVisiteur = emailVisiteur;
    }

    public Long getIdBillet() {
        return idBillet;
    }

    public void setIdBillet(Long idBillet) {
        this.idBillet = idBillet;
    }

    public String getNomBillet() {
        return nomBillet;
    }

    public void setNomBillet(String nomBillet) {
        this.nomBillet = nomBillet;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    // toString() pour le debug
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
