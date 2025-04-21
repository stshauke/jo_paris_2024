package com.jo_paris_2024.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.jo_paris_2024.dto.OffreDTO;
import com.jo_paris_2024.service.AuthService;
import com.jo_paris_2024.service.JwtService;
import com.jo_paris_2024.service.OffreService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PageController {
    @Autowired
    private JwtService jwtService; // Injecte JwtService
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

    
    @GetMapping("/billetAchetes") // Page des visiteurs
    public String billetAchetesPage(Model model) {
        model.addAttribute("activePage", "billetAchetes"); // Ajouter l'attribut "activePage" pour la page des visiteurs
        return "billetAchetes"; // Renvoie le fichier billetAchates.html
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
    public String achatBilletPage(HttpServletRequest request, Model model) {
        // 1. Essayer de récupérer le token depuis l'en-tête
        String authHeader = request.getHeader("Authorization");
        String token = null;
        
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
            System.out.println("Token trouvé dans l'en-tête: " + token.substring(0, 15) + "...");
        }
        
        // 2. Si pas dans l'en-tête, chercher dans les cookies
        if (token == null) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if ("jwtToken".equals(cookie.getName())) {
                        token = cookie.getValue();
                        System.out.println("Token trouvé dans les cookies: " + token.substring(0, 15) + "...");
                        break;
                    }
                }
            }
        }
        
        // Si toujours aucun token, rediriger
        if (token == null) {
            System.out.println("❌ Aucun token trouvé, redirection...");
            return "redirect:/connexion";
        }
        
        // Valider le token
        String email = jwtService.extractEmail(token);
        if (email == null || !jwtService.isTokenValid(token, email)) {
            System.out.println("⛔ Token invalide pour l'email: " + email);
            return "redirect:/connexion";
        }
        
        model.addAttribute("activePage", "Achat");
        return "achat_billet";
    }
}
