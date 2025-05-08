package com.jo_paris_2024.service;

import com.jo_paris_2024.entity.Billet;
import com.jo_paris_2024.entity.Panier;
import com.jo_paris_2024.entity.Visiteur;
import com.jo_paris_2024.repository.BilletRepository;
import com.jo_paris_2024.repository.PanierRepository;
import com.jo_paris_2024.repository.VisiteurRepository;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional
public class PaiementService {

    private static final Logger logger = LoggerFactory.getLogger(PaiementService.class);

    @Autowired
    private VisiteurRepository visiteurRepository;

    @Autowired
    private BilletRepository billetRepository;

    @Autowired
    private PanierRepository panierRepository;

    @Autowired
    private JavaMailSender mailSender;

    /**
     * Méthode de simulation utilisée pour les tests.
     */
    public boolean effectuerPaiement(double montant) {
        if (montant > 0) {
            logger.info("Paiement simulé de {}€ effectué avec succès.", montant);
            return true;
        } else {
            logger.error("Erreur lors du paiement simulé : montant invalide.");
            return false;
        }
    }

    /**
     * Méthode appelée après un paiement réel via Stripe.
     * Elle réduit le stock, enregistre les achats et envoie un mail.
     */
    public void traiterPaiementApresSuccess(String email, List<Map<String, Object>> billets) {
        logger.info("Traitement du paiement réel pour {}", email);

        Visiteur visiteur = visiteurRepository.findByEmailVisiteur(email)
                .orElseThrow(() -> new RuntimeException("Visiteur non trouvé avec l'email : " + email));

        StringBuilder contenuMail = new StringBuilder("Merci pour votre achat !\n\nVoici les billets achetés :\n");

        for (Map<String, Object> billetMap : billets) {
            Long idBillet = Long.valueOf(billetMap.get("id").toString());

            Billet billet = billetRepository.findById(idBillet)
                    .orElseThrow(() -> new RuntimeException("Billet introuvable avec l'ID : " + idBillet));

            if (billet.getStock() <= 0) {
                throw new RuntimeException("Stock insuffisant pour le billet " + billet.getId_billet());
            }

            // Réduction du stock
            billet.setStock(billet.getStock() - 1);
            billetRepository.save(billet);

            // Création du panier
            Panier panier = new Panier();
            panier.setId_billet(Math.toIntExact(billet.getId_billet()));
            panier.setId_visiteur(Math.toIntExact(visiteur.getId_visiteur()));
            panier.setBillet(billet);
            panier.setVisiteur(visiteur);
            panier.setDate_ajout(LocalDateTime.now());
            panier.setIdentifiant_billet("BILLET-" + billet.getId_billet());
            panier.setCle_unique(UUID.randomUUID().toString());
            panier.setQuantite(1);
            panier.setPrix(billet.getPrix_billet().doubleValue());


            panierRepository.save(panier);

            // Contenu de l'email
            contenuMail.append("• ").append(billet.getType_billet())
                       .append(" - ").append(billet.getPrix_billet())
                       .append("€\n");
        }

        // Envoi de l'email de confirmation
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject("Confirmation d'achat - JO Paris 2024");
            message.setText(contenuMail.toString());

            mailSender.send(message);
            logger.info("Email de confirmation envoyé à {}", email);
        } catch (Exception e) {
            logger.error("Erreur lors de l'envoi de l'email de confirmation à {}", email, e);
        }
    }
}
