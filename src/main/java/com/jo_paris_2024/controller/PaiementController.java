package com.jo_paris_2024.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.jo_paris_2024.dto.PaiementRequestDTO;
import com.jo_paris_2024.service.PaiementService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/paiement")
@Validated
public class PaiementController {

    @Autowired
    private PaiementService paiementService;

    @PostMapping("/simuler")
    public ResponseEntity<?> simulerPaiement(@Valid @RequestBody PaiementRequestDTO paiementRequest) {
        boolean paiementReussi = paiementService.effectuerPaiement(paiementRequest.getMontant());

        if (paiementReussi) {
            // Retourner une réponse JSON avec un message de succès
            return ResponseEntity.ok(Map.of("message", "Paiement effectué avec succès."));
        } else {
            // Retourner une réponse JSON avec un message d'échec
            return ResponseEntity.badRequest().body(Map.of("message", "Échec du paiement : montant invalide."));
        }
    }
}
