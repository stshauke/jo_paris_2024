package com.jo_paris_2024.repository;

import com.jo_paris_2024.entity.Visiteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisiteurRepository extends JpaRepository<Visiteur, Long> {
	 // Les méthodes CRUD sont déjà incluses par défaut grâce à JpaRepository
}
