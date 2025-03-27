package com.jo_paris_2024.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        // Récupérer le code d'erreur
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");

        // Déterminer le message à afficher
        String message;
        if (statusCode != null) {
            switch (statusCode) {
                case 401:
                    message = "Accès non autorisé. Veuillez vous connecter.";
                    break;
                case 403:
                    message = "Vous n'avez pas la permission d'accéder à cette page.";
                    break;
                case 404:
                    message = "Page non trouvée.";
                    break;
                case 500:
                    message = "Erreur interne du serveur.";
                    break;
                default:
                    message = "Une erreur inattendue est survenue.";
            }
        } else {
            message = "Une erreur inconnue est survenue.";
        }

        // Ajouter le message au modèle Thymeleaf
        model.addAttribute("message", message);
        model.addAttribute("statusCode", statusCode);

        // Retourner la page error.html
        return "error";
    }
}
