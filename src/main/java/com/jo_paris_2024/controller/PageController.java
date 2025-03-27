package com.jo_paris_2024.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jo_paris_2024.dto.OffreDTO;
import com.jo_paris_2024.service.AuthService;
import com.jo_paris_2024.service.OffreService;

@Controller
public class PageController {
	 @Autowired
	    private AuthService authService;  // Service pour valider le token
    @Autowired
    private OffreService offreService;

    @GetMapping("/") // Page d'accueil
    public String indexPage(Model model) {
        model.addAttribute("activePage", "home"); // Ajouter l'attribut "activePage" pour la page d'accueil
        List<OffreDTO> offres = offreService.getAllOffres();
        model.addAttribute("offres", offres);
        return "index"; // Renvoie le fichier index.html
    }

    @GetMapping("/stade") // Page du stade
    public String stadePage(Model model) {
        model.addAttribute("activePage", "stade"); // Ajouter l'attribut "activePage" pour la page du stade
        return "stade"; // Renvoie le fichier stade.html
    }

    @GetMapping("/visiteur") // Page des visiteurs
    public String visiteurPage(Model model) {
        model.addAttribute("activePage", "visiteur"); // Ajouter l'attribut "activePage" pour la page des visiteurs
        return "visiteur"; // Renvoie le fichier visiteur.html
    }

    @GetMapping("/inscription") // Page d'inscription
    public String inscription_visiteurPage(Model model) {
        model.addAttribute("activePage", "inscription"); // Ajouter l'attribut "activePage" pour la page d'inscription
        return "inscription_visiteur"; // Renvoie le fichier inscription_visiteur.html
    }

    @GetMapping("/connexion") // Page de connexion
    public String connexionVisiteurPage(Model model) {
        model.addAttribute("activePage", "connexion"); // Ajouter l'attribut "activePage" pour la page de connexion
        return "connexion_visiteur"; // Renvoie le fichier connexion_visiteur.html
    }

    @GetMapping("/offre")
    public String offrePage(Model model) {
        model.addAttribute("activePage", "Offres");
        return "offre";
    }

    @GetMapping("/billet")
    public String billetPage(Model model) {
        model.addAttribute("activePage", "Billets");
        return "billet";
    }

    @GetMapping("/achat")
    public String achatBilletPage(Model model) {
        // Récupérer le token depuis le contexte de sécurité
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String token = authentication != null ? authentication.getCredentials().toString() : null;
        
        // Récupérer l'email de l'utilisateur connecté
        String email = authentication != null ? authentication.getName() : null;  // L'email est généralement stocké comme principal
        
        // Si le token ou l'email est absent ou si le token est invalide, rediriger vers la page de connexion
        if (token == null || email == null || !authService.isTokenValid(token, email)) {
            return "redirect:/connexion";  // Redirection vers la page de connexion si le token ou l'email est invalide
        }

        model.addAttribute("activePage", "Achat");
        return "achat_billet";  // Renvoie le fichier achat_billet.html
    }


    @GetMapping("/qr_code") // Page des QR codes
    public String showQRCodePage(Model model) {
        model.addAttribute("activePage", "qr_code"); // Ajouter l'attribut "activePage" pour la page QR Code
        return "qr_code"; // Renvoie le fichier qr_code.html
    }
}

