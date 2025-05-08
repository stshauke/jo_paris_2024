package com.jo_paris_2024.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.jo_paris_2024.service.PaiementService;

import org.springframework.ui.Model; // ✅ Correct
import jakarta.servlet.http.HttpSession;

@Controller
public class StripeRedirectController {

    @Autowired
    private PaiementService paiementService;

    @GetMapping("/success")
    public String paymentSuccess(HttpSession session, Model model) {
        String email = (String) session.getAttribute("emailVisiteur");
        List<Map<String, Object>> panier = (List<Map<String, Object>>) session.getAttribute("panier");

        if (email != null && panier != null) {
            paiementService.traiterPaiementApresSuccess(email, panier);

            // Nettoyer la session
            session.removeAttribute("emailVisiteur");
            session.removeAttribute("panier");
        }

        model.addAttribute("message", "Paiement réussi !");
        return "success";
    }

    @GetMapping("/cancel")
    public String paymentCancel() {
        return "cancel";
    }
}
