package com.jo_paris_2024.service;

// Import du DTO pour transférer les détails du panier
import com.jo_paris_2024.dto.PanierDetailsDTO;
// Import de la projection utilisée pour récupérer les données de la base
import com.jo_paris_2024.repository.PanierDetailsProjection;
// Import du repository du panier pour interagir avec la base de données
import com.jo_paris_2024.repository.PanierRepository;

import org.springframework.beans.factory.annotation.Autowired;
// Annotation pour déclarer un service Spring
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Déclaration de la classe comme un service Spring
@Service
public class PanierDetailsService {

    // Injection automatique du repository de panier par Spring
    @Autowired
    private PanierRepository panierRepository;

    // Méthode pour récupérer tous les détails des paniers
    public List<PanierDetailsDTO> getAllPanierDetails() {
        // Exécution de la requête native définie dans le repository pour obtenir les projections des détails du panier
        List<PanierDetailsProjection> projections = panierRepository.findAllPanierDetailsNative();

        // Transformation des projections en objets DTO à l'aide d'un stream
        return projections.stream()
                .map(projection -> new PanierDetailsDTO(
                        projection.getIdPanier(),          // ID du panier
                        projection.getIdVisiteur(),        // ID du visiteur
                        projection.getNomVisiteur(),       // Nom du visiteur
                        projection.getEmailVisiteur(),     // Email du visiteur
                        projection.getIdBillet(),          // ID du billet
                        projection.getNomBillet(),         // Nom du billet
                        projection.getQuantite(),          // Quantité de billets
                        projection.getPrix()               // Prix du billet
                ))
                .collect(Collectors.toList()); // Collecte le flux en une liste
    }

    // Méthode pour calculer le nombre total de billets achetés
    public long getTotalBilletsAchetes() {
        // Récupère tous les détails des paniers, puis additionne les quantités de billets
        return getAllPanierDetails().stream()
                .mapToLong(PanierDetailsDTO::getQuantite) // Extrait la quantité pour chaque DTO
                .sum(); // Fait la somme de toutes les quantités
    }

    // Méthode pour calculer le montant total des billets achetés
    public double getTotalMontantBillets() {
        // Récupère tous les détails des paniers, puis calcule la somme du prix * quantité pour chaque ligne
        return getAllPanierDetails().stream()
                .mapToDouble(dto -> dto.getPrix() * dto.getQuantite()) // Multiplie prix par quantité
                .sum(); // Fait la somme totale
    }
}
