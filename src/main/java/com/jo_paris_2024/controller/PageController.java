package com.jo_paris_2024.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/") // Page d'accueil
    public String indexPage() {
        return "index"; // Renvoie le fichier index.html
    }

    @GetMapping("/stade") // Page du stade
    public String stadePage() {
        return "stade"; // Renvoie le fichier stade.html
    }
    @GetMapping("/visiteur") // Page du stade
    public String visiteurPage() {
        return "visiteur"; // Renvoie le fichier stade.html
    }
    @GetMapping("/inscription") // Page du stade
    public String inscription_visiteurPage() {
        return "inscription_visiteur"; // Renvoie le fichier stade.html
    }
    @GetMapping("/connexion") // Page de connexion
    public String connexionVisiteurPage() {
        return "connexion_visiteur"; // Renvoie le fichier connexion_visiteur.html
    }
}