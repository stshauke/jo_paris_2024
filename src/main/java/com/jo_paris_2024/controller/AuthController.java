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

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final VisiteurService visiteurService;
    private final JwtService jwtService;

    public AuthController(VisiteurService visiteurService, JwtService jwtService) {
        this.visiteurService = visiteurService;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody ConnexionVisiteurDTO connexionVisiteurDTO) {
        String email = connexionVisiteurDTO.getEmail();  // Utiliser getEmail() à partir de ConnexionVisiteurDTO
        String password = connexionVisiteurDTO.getPassword();  // Utiliser getPassword() à partir de ConnexionVisiteurDTO

        System.out.println("📢 Tentative de connexion pour : " + email);  // 🔥 Vérification console

        // Vérifier les identifiants
        VisiteurDTO visiteur = visiteurService.authenticateVisiteur(email, password);

        if (visiteur == null) {
            System.out.println("❌ Erreur : Identifiants incorrects !");
            return ResponseEntity.status(401).body(Collections.singletonMap("error", "Email ou mot de passe incorrect"));
        }

        // Générer un token JWT
        String token = jwtService.generateToken(email);
        System.out.println("✅ Jeton généré : " + token);  // 🔥 Vérification console

        // Créer une réponse avec les informations nécessaires
        LoginResponse loginResponse = new LoginResponse(token, visiteur.getEmailVisiteur(), visiteur.getNomVisiteur());

        // Retourner la réponse avec le token et les autres informations
        return ResponseEntity.ok(Collections.singletonMap("token", loginResponse.getToken()));
    }
}
