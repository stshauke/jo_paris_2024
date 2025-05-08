package com.jo_paris_2024.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class Panier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_panier;

    private Integer id_visiteur;

    private Integer id_billet;

    //@Column(nullable = false)
    private String identifiant_billet;  // Identifiant unique pour chaque billet acheté

    private LocalDateTime date_ajout;
    
    private String cle_unique; //clé unique pour chaque billet acheté
    
    //Cest le type blob dans la base de données pour enregistrer des images dans la base
    @Lob
    @Column(name="qr_code_image")
    private byte[] qr_code_image;

 // Quantité de billets dans ce panier
    @Column(name = "quantite")
    private Integer quantite;

    // Prix unitaire du billet (ou total selon ta logique)
    @Column(name = "prix")
    private Double prix;

    
    
    
    
    // Constructeur par défaut
    public Panier() {}

    // Constructeur avec arguments
    /*public Panier(Integer id_panier, Integer id_visiteur, Integer id_billet, 
    		String identifiant_billet, LocalDateTime date_ajout, String cle_unique, byte[] qrCodeImage) {
    	this.id_panier = id_panier;
    	this.id_visiteur = id_visiteur;
        this.id_billet = id_billet;
        this.identifiant_billet = identifiant_billet;
        this.date_ajout = date_ajout;
        this.cle_unique = cle_unique;
        this.qr_code_image = qr_code_image;
    }*/
 // Ancien constructeur (à garder pour compatibilité avec ton code existant)
    public Panier(Integer id_panier, Integer id_visiteur, Integer id_billet, 
        String identifiant_billet, LocalDateTime date_ajout, String cle_unique, byte[] qr_code_image) {
        this.id_panier = id_panier;
        this.id_visiteur = id_visiteur;
        this.id_billet = id_billet;
        this.identifiant_billet = identifiant_billet;
        this.date_ajout = date_ajout;
        this.cle_unique = cle_unique;
        this.qr_code_image = qr_code_image;
    }

    // Nouveau constructeur enrichi pour les méthodes qui en ont besoin
    public Panier(Integer id_panier, Integer id_visiteur, Integer id_billet, 
        String identifiant_billet, LocalDateTime date_ajout, String cle_unique, byte[] qr_code_image,
        Integer quantite, Double prix) {
        this.id_panier = id_panier;
        this.id_visiteur = id_visiteur;
        this.id_billet = id_billet;
        this.identifiant_billet = identifiant_billet;
        this.date_ajout = date_ajout;
        this.cle_unique = cle_unique;
        this.qr_code_image = qr_code_image;
        this.quantite = quantite;
        this.prix = prix;
    }

    // Getters et Setters
    public Integer getId_panier() {
        return id_panier;
    }

    public void setId_panier(Integer id_panier) {
        this.id_panier = id_panier;
    }

    public Integer getId_visiteur() {
        return id_visiteur;
    }

    public void setId_visiteur(Integer id_visiteur) {
        this.id_visiteur = id_visiteur;
    }

    public Integer getId_billet() {
        return id_billet;
    }

    public void setId_billet(Integer id_billet) {
        this.id_billet = id_billet;
    }

    public String getCle_unique() {
        return cle_unique;
    }

    public void setCle_unique(String cle_unique) {
        this.cle_unique = cle_unique;
    }
    
     public String getIdentifiant_billet() {
        return identifiant_billet;
    }

    public void setIdentifiant_billet(String identifiant_billet) {
        this.identifiant_billet = identifiant_billet;
    }
    
    

    public LocalDateTime getDate_ajout() {
        return date_ajout;
    }

    public void setDate_ajout(LocalDateTime date_ajout) {
        this.date_ajout = date_ajout;
    }
    public byte[] getQr_code_image() {
    	return qr_code_image;
    }
    public void setQr_code_image(byte[] qr_code_image) {
    	this.qr_code_image=qr_code_image;
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
    
    @ManyToOne
    @JoinColumn(name = "id_visiteur", insertable = false, updatable = false)
    private Visiteur visiteur;

    @ManyToOne
    @JoinColumn(name = "id_billet", insertable = false, updatable = false)
    private Billet billet;

    // Getters
    public Visiteur getVisiteur() {
        return visiteur;
    }

    public Billet getBillet() {
        return billet;
    }
    public void setBillet(Billet billet) {
        this.billet = billet;
    }

    public void setVisiteur(Visiteur visiteur) {
        this.visiteur = visiteur;
    }

}
