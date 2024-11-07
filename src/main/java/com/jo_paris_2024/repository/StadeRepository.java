package com.jo_paris_2024.repository;

import com.jo_paris_2024.entity.Stade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StadeRepository extends JpaRepository<Stade, Long> {
    // Les méthodes CRUD sont déjà incluses par défaut grâce à JpaRepository
}
