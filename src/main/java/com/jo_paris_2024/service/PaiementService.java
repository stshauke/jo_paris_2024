package com.jo_paris_2024.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

/**
 * Service responsable de la gestion des paiements.
 * Ce service permet d'effectuer des paiements et enregistre les résultats de ces opérations via des logs.
 */
@Service
@Transactional  // Cette annotation indique que les méthodes de cette classe doivent être exécutées dans une transaction.
public class PaiementService {

    // Déclaration d'un logger pour enregistrer les événements dans le système de logs.
    // Utilisation de SLF4J (Simple Logging Facade for Java) avec Logback (implémentation par défaut dans Spring Boot).
    private static final Logger logger = LoggerFactory.getLogger(PaiementService.class);

    /**
     * Méthode permettant d'effectuer un paiement pour un montant donné.
     * 
     * @param montant Le montant à payer. Si ce montant est positif, le paiement est considéré comme réussi.
     * @return true si le paiement est effectué avec succès, false sinon (si le montant est invalide).
     */
    public boolean effectuerPaiement(double montant) {
        // Vérifie si le montant est positif avant d'effectuer le paiement
        if (montant > 0) {
            // Si le montant est valide (positif), un log d'information est généré et le paiement est considéré comme réussi
            logger.info("Paiement de {}€ effectué avec succès.", montant);
            return true;
        } else {
            // Si le montant est invalide (négatif ou égal à zéro), un log d'erreur est généré
            logger.error("Erreur lors du paiement : montant invalide.");
            return false;
        }
    }
    public void traiterPaiementApresSuccess(String email, List<Map<String, Object>> billets) {
        // Pour l'instant, on simule juste l'effet par un log
        logger.info("Paiement confirmé pour l'utilisateur : {}", email);
        logger.info("Billets achetés : {}", billets);

        // Plus tard ici :
        // - réduction stock
        // - sauvegarde en base
        // - envoi email
    }

}
