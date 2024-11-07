package com.jo_paris_2024.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/stade") // Assurez-vous que ce chemin ne cause pas de conflit avec d'autres contrôleurs
    public String stadePage() {
        return "stade"; // Renvoie le nom du fichier students.html sans extension
    }
}

