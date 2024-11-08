package com.jo_paris_2024.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Stade {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Utilise une auto-incrémentation

    private Long id_stade;  // Utilisation du même nom que dans le DTO
    private String nom_stade;  // Utilisation du même nom que dans le DTO
    private String adresse_stade;  // Utilisation du même nom que dans le DTO
}
