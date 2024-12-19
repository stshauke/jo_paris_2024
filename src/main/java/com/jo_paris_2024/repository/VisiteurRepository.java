package com.jo_paris_2024.repository;

import com.jo_paris_2024.entity.Visiteur;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VisiteurRepository extends JpaRepository<Visiteur, Long> {
	 // Les méthodes CRUD sont déjà incluses par défaut grâce à JpaRepository
    boolean existsByEmailVisiteur(String emailVisiteur);  // Change this if the field name is different
    Optional<Visiteur> findByEmailVisiteur(String email);

}
