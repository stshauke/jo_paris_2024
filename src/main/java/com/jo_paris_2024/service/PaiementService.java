package com.jo_paris_2024.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PaiementService {

    private static final Logger logger = LoggerFactory.getLogger(PaiementService.class);

    public boolean effectuerPaiement(double montant) {
        if (montant > 0) {
            logger.info("Paiement de {}€ effectué avec succès.", montant);
            return true;
        } else {
            logger.error("Erreur lors du paiement : montant invalide.");
            return false;
        }
    }
}
