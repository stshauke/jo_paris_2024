package com.jo_paris_2024.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * Contrôleur REST pour gérer la récupération des QR Codes associés aux paniers des visiteurs.
 */
@RestController
public class QRCodeController {

    private final DataSource dataSource; // Source de données pour exécuter les requêtes SQL

    /**
     * Constructeur injectant la source de données.
     *
     * @param dataSource La source de données permettant d'accéder à la base de données.
     */
    public QRCodeController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * Endpoint permettant de récupérer l'image du QR Code associée à un panier spécifique.
     *
     * @param panierId Identifiant du panier pour lequel on veut récupérer le QR Code.
     * @return Une réponse contenant l'image encodée en base64 et d'autres informations,
     *         ou un statut 404 si le panier n'existe pas.
     * @throws Exception En cas d'erreur lors de l'exécution de la requête SQL.
     */
    @GetMapping("/api/v1/paniers/{id}/qr-code")
    public ResponseEntity<Map<String, Object>> getQRCodeImage(@PathVariable("id") Long panierId) throws Exception {
        // Requête SQL pour récupérer l'image du QR Code ainsi que les informations du visiteur et du billet
        String sql = "SELECT p.qr_code_image, CONCAT(v.nom_visiteur, ' ', v.prenom_visiteur) AS nom_prenom, " +
                     "DATE_FORMAT(p.date_ajout, '%Y%m%d%H%i%s') AS numero, " +
                     "DATE_FORMAT(p.date_ajout, '%e/%c %H:%i') AS date_formatee, " +
                     "b.type_billet AS type_billet " +
                     "FROM panier p " +
                     "JOIN visiteur v ON v.id_visiteur = p.id_visiteur " +
                     "JOIN billet b ON p.id_billet = b.id_billet " +
                     "WHERE id_panier = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, panierId);
            ResultSet rs = stmt.executeQuery();

            // Vérifier si des résultats ont été trouvés
            if (rs.next()) {
                byte[] qrCodeImage = rs.getBytes("qr_code_image"); // Récupération de l'image QR Code
                String nomPrenom = rs.getString("nom_prenom"); // Nom complet du visiteur
                String numero = rs.getString("numero"); // Numéro généré à partir de la date d'ajout
                String typeBillet = rs.getString("type_billet"); // Type de billet
                String dateFormatee = rs.getString("date_formatee"); // Date formatée pour l'affichage

                // Création de la réponse sous forme de map
                Map<String, Object> response = new HashMap<>();
                response.put("qrCodeImage", Base64.getEncoder().encodeToString(qrCodeImage)); // Encodage Base64 de l'image
                response.put("nomPrenom", nomPrenom);
                response.put("numero", numero);
                response.put("type_billet", typeBillet);
                response.put("date_formatee", dateFormatee);

                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retourne 404 si aucun QR Code trouvé
            }
        } catch (Exception e) {
            throw new Exception("Erreur lors de la récupération de l'image QR Code", e);
        }
    }
}
