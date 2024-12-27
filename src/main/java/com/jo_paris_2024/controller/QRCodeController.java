package com.jo_paris_2024.controller;

import org.springframework.http.HttpHeaders;
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

@RestController
public class QRCodeController {

    private final DataSource dataSource;

    public QRCodeController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // Endpoint pour récupérer l'image QR Code à partir du panier
    @GetMapping("/api/v1/paniers/{id}/qr-code")
    public ResponseEntity<Map<String, Object>> getQRCodeImage(@PathVariable("id") Long panierId) throws Exception {
        String sql = "SELECT p.qr_code_image,concat(v.nom_visiteur,\" \", v.prenom_visiteur) as nom_prenom, \r\n"
        		+ "DATE_FORMAT(p.date_ajout, '%Y%m%d%H%i%s') AS numero,DATE_FORMAT(p.date_ajout, '%e/%c %H:%i') AS date_formatee, b.type_billet as type_billet\r\n"
        		+ " FROM panier p ,visiteur v, billet b\r\n"
        		+ "WHERE v.id_visiteur=p.id_visiteur\r\n"
        		+ "and p.id_billet=b.id_billet\r\n"
        		+ "and id_panier = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, panierId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                byte[] qrCodeImage = rs.getBytes("qr_code_image");
                String nomPrenom = rs.getString("nom_prenom");
                String numero = rs.getString("numero");
                String type_billet = rs.getString("type_billet");
                 String date_formatee = rs.getString("date_formatee");
                Map<String, Object> response = new HashMap<>();
                response.put("qrCodeImage", Base64.getEncoder().encodeToString(qrCodeImage));  // Encode image as base64
                response.put("nomPrenom", nomPrenom);
                response.put("numero", numero);
                response.put("type_billet", type_billet);
                response.put("date_formatee", date_formatee);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            throw new Exception("Erreur lors de la récupération de l'image QR Code", e);
        }
    }
}
