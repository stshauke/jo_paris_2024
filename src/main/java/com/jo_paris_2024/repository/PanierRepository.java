package com.jo_paris_2024.repository;

// Importation de JpaRepository pour bénéficier des méthodes CRUD
import org.springframework.data.jpa.repository.JpaRepository;
// Importation de l'annotation @Query pour écrire des requêtes personnalisées
import org.springframework.data.jpa.repository.Query;

import com.jo_paris_2024.entity.Panier;

import java.util.List;
import java.util.Map;

// Interface PanierRepository qui hérite de JpaRepository
// Cela permet d'avoir toutes les opérations de base sur l'entité Panier
public interface PanierRepository extends JpaRepository<Panier, Long> {

    // Requête native personnalisée pour récupérer les détails des paniers
    // La requête fait une jointure entre les tables panier, visiteur et billet
    // Elle sélectionne des colonnes spécifiques et les mappe dans une projection personnalisée (PanierDetailsProjection)
    @Query(value = "SELECT p.id_panier as idPanier, " +                        // ID du panier
                   "v.id_visiteur as idVisiteur, " +                          // ID du visiteur
                   "CONCAT(v.nom_visiteur, ' ', v.prenom_visiteur) as nomVisiteur, " + // Nom complet du visiteur
                   "v.email_visiteur as emailVisiteur, " +                    // Email du visiteur
                   "b.id_billet as idBillet, " +                              // ID du billet
                   "b.type_billet as nomBillet, " +                           // Type de billet
                   "p.quantite as quantite, " +                               // Quantité de billets dans le panier
                   "p.prix as prix " +                                        // Prix total ou prix du panier
                   "FROM panier p " +                                         // Table panier
                   "JOIN visiteur v ON v.id_visiteur = p.id_visiteur " +      // Jointure avec la table visiteur
                   "JOIN billet b ON p.id_billet = b.id_billet",              // Jointure avec la table billet
           nativeQuery = true) // Indique qu'on utilise une requête SQL native
    List<PanierDetailsProjection> findAllPanierDetailsNative(); // Retourne une liste de projections avec les détails du panier
}
