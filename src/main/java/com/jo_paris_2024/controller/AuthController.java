package com.jo_paris_2024.controller;

import com.jo_paris_2024.dto.ConnexionVisiteurDTO;
import com.jo_paris_2024.dto.LoginResponse;
import com.jo_paris_2024.dto.VisiteurDTO;
import com.jo_paris_2024.service.JwtService;
import com.jo_paris_2024.service.VisiteurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Collections;

/**
 * Contrôleur responsable de l'authentification des visiteurs.
 * Gère les connexions et la génération de tokens JWT.
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final VisiteurService visiteurService;
    private final JwtService jwtService;

    /**
     * Constructeur injectant les services nécessaires pour l'authentification.
     * 
     * @param visiteurService Service de gestion des visiteurs.
     * @param jwtService Service de gestion des tokens JWT.
     */
    public AuthController(VisiteurService visiteurService, JwtService jwtService) {
        this.visiteurService = visiteurService;
        this.jwtService = jwtService;
    }

    /**
     * Endpoint permettant à un visiteur de se connecter.
     * Vérifie les identifiants et génère un token JWT en cas de succès.
     * 
     * @param connexionVisiteurDTO Objet contenant les informations de connexion (email, mot de passe).
     * @return Une réponse HTTP contenant soit un token JWT en cas de succès, soit un message d'erreur en cas d'échec.
     */
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody ConnexionVisiteurDTO connexionVisiteurDTO) {
        // Récupération des identifiants depuis le DTO
        String email = connexionVisiteurDTO.getEmail();
        String password = connexionVisiteurDTO.getPassword();

        System.out.println("📢 Tentative de connexion pour : " + email);  // 🔥 Log pour suivi

        // Authentifier le visiteur avec les identifiants fournis
        VisiteurDTO visiteur = visiteurService.authenticateVisiteur(email, password);

        // Si l'authentification échoue, retourner une erreur 401 (Unauthorized)
        if (visiteur == null) {
            System.out.println("❌ Erreur : Identifiants incorrects !");
            return ResponseEntity.status(401).body(Collections.singletonMap("error", "Email ou mot de passe incorrect"));
        }

        // Génération du token JWT après une authentification réussie
        String token = jwtService.generateToken(email);
        System.out.println("✅ Jeton généré : " + token);  // 🔥 Log pour vérification

        // Création de l'objet réponse contenant le token et les informations du visiteur
        LoginResponse loginResponse = new LoginResponse(token, visiteur.getEmailVisiteur(), visiteur.getNomVisiteur());

        // Retourner une réponse HTTP 200 avec le token
        return ResponseEntity.ok(Collections.singletonMap("token", loginResponse.getToken()));
    }
}
