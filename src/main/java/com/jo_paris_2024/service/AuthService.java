package com.jo_paris_2024.service;

// Importation des classes nécessaires pour l'authentification Spring Security
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// Annotation pour indiquer que cette classe est un service Spring (bean de service)
import org.springframework.stereotype.Service;
// Importation du DTO Visiteur
import com.jo_paris_2024.dto.VisiteurDTO;

// Annotation pour déclarer un service Spring géré par le conteneur
@Service
public class AuthService {

    // Déclaration des dépendances du service
    private final AuthenticationManager authenticationManager; // Gère le processus d'authentification
    private final VisiteurService visiteurService; // Service métier pour gérer les visiteurs
    private final JwtService jwtService; // Service pour gérer les tokens JWT

    // Constructeur pour injecter les dépendances via injection de dépendances
    public AuthService(AuthenticationManager authenticationManager, VisiteurService visiteurService, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.visiteurService = visiteurService;
        this.jwtService = jwtService;
    }

    // Méthode pour authentifier un utilisateur via son email et mot de passe
    public String authenticate(String email, String password) {
        // Utilisation de AuthenticationManager pour valider les identifiants
        // Si l'authentification échoue, une exception est levée
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));

        // Appel au VisiteurService pour vérifier les informations du visiteur ou obtenir ses détails
        VisiteurDTO visiteur = visiteurService.authenticateVisiteur(email, password);

        // Génération d'un token JWT pour l'utilisateur authentifié
        return jwtService.generateToken(email);
    }

    // Méthode pour vérifier la validité d'un token JWT par rapport à un email donné
    public boolean isTokenValid(String token, String email) {
        try {
            // Vérifie si le token est valide pour l'email donné
            return jwtService.isTokenValid(token, email);
        } catch (Exception e) {
            // En cas d'exception (ex : token expiré ou signature invalide), retourne false
            return false;
        }
    }

}
