package com.jo_paris_2024.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.jo_paris_2024.dto.PaiementRequestDTO;
import com.jo_paris_2024.service.PaiementService;

import jakarta.servlet.http.HttpSession;
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
            return ResponseEntity.ok(Map.of("message", "Paiement effectué avec succès."));
        } else {
            return ResponseEntity.badRequest().body(Map.of("message", "Échec du paiement : montant invalide."));
        }
    }

    // AJOUT ICI — Enregistre email + panier en session AVANT Stripe
    @PostMapping("/cache-session")
    public ResponseEntity<?> cachePaiementEnSession(@RequestBody PaiementRequestDTO dto, HttpSession session) {
        session.setAttribute("emailVisiteur", dto.getEmail());
        session.setAttribute("panier", dto.getBillets());
        return ResponseEntity.ok(Map.of("message", "Session prête"));
    }
}
