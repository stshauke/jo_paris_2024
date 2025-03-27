package com.jo_paris_2024.controller;

import com.jo_paris_2024.dto.ConnexionVisiteurDTO;
import com.jo_paris_2024.dto.LoginResponse;
import com.jo_paris_2024.dto.VisiteurDTO;
import com.jo_paris_2024.entity.Visiteur;
import com.jo_paris_2024.repository.VisiteurRepository;
import com.jo_paris_2024.service.JwtService;
import com.jo_paris_2024.service.VisiteurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

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
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String password = request.get("password");

        // Vérifier les identifiants
        VisiteurDTO visiteur = visiteurService.authenticateVisiteur(email, password);

        // Générer un token JWT
        String token = jwtService.generateToken(email);

        return ResponseEntity.ok(Collections.singletonMap("token", token));
    }
}
