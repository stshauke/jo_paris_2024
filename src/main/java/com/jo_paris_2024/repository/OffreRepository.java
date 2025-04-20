package com.jo_paris_2024.repository;

// Import de l'interface JpaRepository de Spring Data JPA
import org.springframework.data.jpa.repository.JpaRepository;

// Import de l'entité Offre que ce repository va gérer
import com.jo_paris_2024.entity.Offre;

// Interface qui sert de repository pour l'entité Offre
// Elle hérite de JpaRepository, ce qui fournit automatiquement des méthodes CRUD (Create, Read, Update, Delete)
// Le premier paramètre est l'entité gérée (Offre), le second est le type de la clé primaire (Long)
public interface OffreRepository extends JpaRepository<Offre, Long> {
    // Aucun besoin de définir des méthodes ici pour les opérations de base :
    // JpaRepository fournit déjà des méthodes telles que :
    // - findAll()
    // - findById()
    // - save()
    // - deleteById()
    // - etc.

    // Si besoin, on pourra ajouter des méthodes personnalisées ici plus tard.
}
