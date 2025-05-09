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
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.io.ByteArrayOutputStream;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;

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

    public boolean effectuerPaiement(double montant) {
        if (montant > 0) {
            logger.info("Paiement simulé de {}€ effectué avec succès.", montant);
            return true;
        } else {
            logger.error("Erreur lors du paiement simulé : montant invalide.");
            return false;
        }
    }

    public void traiterPaiementApresSuccess(String email, List<Map<String, Object>> billets) {
        logger.info("Traitement du paiement réel pour {}", email);

        Visiteur visiteur = visiteurRepository.findByEmailVisiteur(email)
                .orElseThrow(() -> new RuntimeException("Visiteur non trouvé avec l'email : " + email));

        StringBuilder contenuHtml = new StringBuilder();
        contenuHtml.append("<p>Merci pour votre achat, <strong>")
                   .append(visiteur.getPrenom_visiteur()).append(" ")
                   .append(visiteur.getNom_visiteur())
                   .append("</strong> !</p>");

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

            // Ajouter billet dans contenu email HTML
            contenuHtml.append("<hr>")
                       .append("<p><strong>Type :</strong> ").append(billet.getType_billet()).append("</p>")
                       .append("<p><strong>Prix :</strong> ").append(billet.getPrix_billet()).append(" €</p>");
        }

        try {
            // Générer QR Code personnalisé
            String qrText = "Achat JO Paris 2024 - " + email + " - " + LocalDateTime.now();
            byte[] qrCode = genererQrCode(qrText);

            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(email);
            helper.setSubject("Confirmation d'achat - JO Paris 2024");

            contenuHtml.append("<p>Voici votre QR Code :</p>")
                       .append("<img src='cid:qrCodeImage' alt='QR Code' width='200' height='200'/>")
                       .append("<p>🎉 À très bientôt aux JO 2024 !</p>");

            helper.setText(contenuHtml.toString(), true);
            helper.addInline("qrCodeImage", new ByteArrayResource(qrCode), "image/png");

            mailSender.send(message);
            logger.info("Email de confirmation avec QR envoyé à {}", email);

        } catch (Exception e) {
            logger.error("Erreur lors de l'envoi de l'email avec QR code à {}", email, e);
        }
    }

    private byte[] genererQrCode(String texte) throws Exception {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(texte, BarcodeFormat.QR_CODE, 200, 200);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);

        return outputStream.toByteArray();
    }
}
