package com.jo_paris_2024.repository;

import com.jo_paris_2024.entity.Billet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BilletRepository extends JpaRepository<Billet, Long> {
    // Les méthodes CRUD sont déjà incluses par défaut grâce à JpaRepository
}
