package com.jo_paris_2024.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

/**
 * Service responsable de l'envoi d'e-mails avec ou sans pièce jointe (QR Code).
 * Cette classe utilise la bibliothèque JavaMail pour créer et envoyer des messages électroniques.
 */
@Service
public class EmailService {

    // Injection de la dépendance JavaMailSender qui permet d'envoyer des e-mails via Spring
    @Autowired
    private JavaMailSender mailSender;

    /**
     * Méthode pour envoyer un e-mail avec ou sans pièce jointe (par exemple un QR Code).
     * 
     * @param to L'adresse e-mail du destinataire.
     * @param subject Le sujet de l'e-mail.
     * @param body Le contenu de l'e-mail (texte).
     * @param qrCodeBytes Les données du QR Code à envoyer en pièce jointe sous forme de tableau de bytes.
     * @throws MessagingException Si une erreur se produit lors de la création ou de l'envoi du message.
     */
    public void sendEmail(String to, String subject, String body, byte[] qrCodeBytes) throws MessagingException {
        
        // Création du message MIME pour permettre l'ajout de pièces jointes et de contenu HTML
        MimeMessage message = mailSender.createMimeMessage();
        
        // Aide à la construction du message MIME
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        
        // Définition de l'adresse du destinataire
        helper.setTo(to);
        
        // Définition du sujet de l'e-mail
        helper.setSubject(subject);
        
        // Définition du contenu du message (ici, on spécifie "false" pour indiquer que le corps n'est pas en HTML)
        helper.setText(body, false);

        // Si des données de QR Code sont fournies (non null), on ajoute cette pièce jointe
        if (qrCodeBytes != null) {
            
            // Ajout de la pièce jointe sous forme de flux de données
            helper.addAttachment("QRCode.png", new jakarta.activation.DataSource() {
                
                // Méthode pour obtenir le flux d'entrée des données (ici, depuis les bytes du QR Code)
                public java.io.InputStream getInputStream() throws java.io.IOException {
                    return new java.io.ByteArrayInputStream(qrCodeBytes);
                }

                // Méthode pour obtenir le flux de sortie (non supportée dans ce cas)
                public java.io.OutputStream getOutputStream() throws java.io.IOException {
                    throw new UnsupportedOperationException("Not supported");
                }

                // Spécification du type de contenu de la pièce jointe (ici une image PNG)
                public String getContentType() {
                    return "image/png";
                }

                // Nom de la pièce jointe (le fichier sera nommé QRCode.png)
                public String getName() {
                    return "QRCode.png";
                }
            });
        }

        // Envoi du message
        mailSender.send(message);
    }
}
