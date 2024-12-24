package com.jo_paris_2024.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jo_paris_2024.dto.OffreDTO;
import com.jo_paris_2024.service.OffreService;

@Controller
public class PageController {

    @Autowired
    private OffreService offreService;

    @GetMapping("/") // Page d'accueil
    public String indexPage(Model model) {
        // Récupérer toutes les offres depuis le service
        List<OffreDTO> offres = offreService.getAllOffres();
        // Ajouter les offres dans le modèle pour les utiliser dans index.html
        model.addAttribute("offres", offres);

        return "index"; // Renvoie le fichier index.html
    }

    @GetMapping("/stade") // Page du stade
    public String stadePage() {
        return "stade"; // Renvoie le fichier stade.html
    }

    @GetMapping("/visiteur") // Page du stade
    public String visiteurPage() {
        return "visiteur"; // Renvoie le fichier visiteur.html
    }

    @GetMapping("/inscription") // Page d'inscription
    public String inscription_visiteurPage() {
        return "inscription_visiteur"; // Renvoie le fichier inscription_visiteur.html
    }

    @GetMapping("/connexion") // Page de connexion
    public String connexionVisiteurPage() {
        return "connexion_visiteur"; // Renvoie le fichier connexion_visiteur.html
    }

    @GetMapping("/offre") // Page des offres
    public String connexionOffrePage() {
        return "offre"; // Renvoie le fichier offre.html
    }
    @GetMapping("/billet") // Page des offres
    public String connexionBilletPage() {
        return "billet"; // Renvoie le fichier offre.html
    }
    @GetMapping("/achat") // Page des offres
    public String connexionAchatBilletPage() {
        return "achat_billet"; // Renvoie le fichier offre.html
    }
}