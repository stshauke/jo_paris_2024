package com.jo_paris_2024.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import com.jo_paris_2024.dto.VisiteurDTO;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final VisiteurService visiteurService;
    private final JwtService jwtService;

    public AuthService(AuthenticationManager authenticationManager, VisiteurService visiteurService, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.visiteurService = visiteurService;
        this.jwtService = jwtService;
    }

    public String authenticate(String email, String password) {
        // Effectue l'authentification via AuthenticationManager pour lever une exception en cas d'erreur
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));

        // Utilise VisiteurService pour vérifier les identifiants (ou retourner le visiteur authentifié)
        VisiteurDTO visiteur = visiteurService.authenticateVisiteur(email, password);

        // Génère le token JWT à partir de l'email
        return jwtService.generateToken(email);
    }

    // Méthode pour valider un token JWT
    public boolean isTokenValid(String token, String email) {
        try {
            // Utilise la méthode validateToken du JwtService pour valider le token
            return jwtService.validateToken(token, email);  // Cette méthode a été ajoutée dans JwtService
        } catch (Exception e) {
            return false;  // Si une exception est levée (par exemple, token invalide), retournez false
        }
    }
}
