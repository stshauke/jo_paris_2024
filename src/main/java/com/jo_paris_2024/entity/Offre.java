package com.jo_paris_2024.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "offre")
public class Offre {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id_offre;

	    private String nom_offre;
	    private String description_offre;
	    private BigDecimal prix_offre;
	    private Long nombre_personnes;
	    private LocalDate date_fin_offre;

	    // Constructeur sans arguments
	    public Offre() {
	    }
	
	 // Constructeur avec tous les arguments
	    public Offre(Long id_offre, String nom_offre, String description_offre, 
	                   BigDecimal prix_offre, Long nombre_personnes, LocalDate date_fin_offre) {
	        this.id_offre = id_offre;
	        this.nom_offre = nom_offre;
	        this.description_offre = description_offre;
	        this.prix_offre = prix_offre;
	        this.nombre_personnes = nombre_personnes;
	        this.date_fin_offre = date_fin_offre;
	    }

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

	
	
}
