package com.jo_paris_2024.repository;

// Interface de projection pour récupérer des détails du panier
// Cette interface sera utilisée par Spring Data JPA pour extraire
// uniquement les champs nécessaires, sans charger toute l'entité complète.
// Cela permet d’optimiser les requêtes et d’avoir un résultat plus léger.

public interface PanierDetailsProjection {

    // Récupère l'identifiant du panier
    Long getIdPanier();

    // Récupère l'identifiant du visiteur
    Long getIdVisiteur();

    // Récupère le nom du visiteur
    String getNomVisiteur();

    // Récupère l'email du visiteur
    String getEmailVisiteur();

    // Récupère l'identifiant du billet
    Long getIdBillet();

    // Récupère le nom du billet
    String getNomBillet();

    // Récupère la quantité de billets
    Integer getQuantite();

    // Récupère le prix du billet
    Double getPrix();
}
