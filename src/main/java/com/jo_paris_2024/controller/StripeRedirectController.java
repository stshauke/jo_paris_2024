package com.jo_paris_2024.controller;

import com.jo_paris_2024.service.PaiementService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

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
            session.removeAttribute("emailVisiteur");
            session.removeAttribute("panier");
        } else {
            System.out.println("⚠️ Email ou panier introuvable en session !");
        }

        model.addAttribute("message", "Paiement réussi !");
        return "success"; // retourne vers success.html
    }

    @GetMapping("/cancel")
    public String paymentCancel() {
        return "cancel"; // retourne vers cancel.html
    }
}
