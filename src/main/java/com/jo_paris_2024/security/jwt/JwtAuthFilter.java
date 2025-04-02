package com.jo_paris_2024.security.jwt;

import com.jo_paris_2024.service.JwtService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthFilter.class);
    private final JwtService jwtService;

    public JwtAuthFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Récupérer le token JWT, d'abord depuis l'en-tête puis depuis les cookies
        final String token = getJwtToken(request);
        
        // Si aucun token n'est trouvé, continuer la chaîne de filtres
        if (token == null) {
            filterChain.doFilter(request, response);
            return;
        }

        try {
            String email = jwtService.extractEmail(token);
            
            // Si l'email est extrait et qu'aucune authentification n'existe déjà
            if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                // Vérifier la validité du token
                if (jwtService.isTokenValid(token, email)) {
                    // Créer l'authentification avec seulement l'email
                    UsernamePasswordAuthenticationToken authToken = 
                            new UsernamePasswordAuthenticationToken(email, null, List.of());
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                    logger.info("✅ Utilisateur authentifié avec l'email: {}", email);
                } else {
                    logger.warn("⚠️ Token invalide pour l'email: {}", email);
                }
            }
        } catch (ExpiredJwtException e) {
            logger.warn("⌛ Token expiré pour: {}", e.getClaims().getSubject());
            // Ne pas renvoyer d'erreur, laisser Spring Security gérer la redirection
        } catch (Exception e) {
            logger.error("❌ Erreur lors de la validation du token: {}", e.getMessage());
            // Ne pas renvoyer d'erreur, laisser Spring Security gérer la redirection
        }

        // Continuer la chaîne de filtres
        filterChain.doFilter(request, response);
    }
    
    /**
     * Récupère le token JWT depuis l'en-tête Authorization ou les cookies
     */
    private String getJwtToken(HttpServletRequest request) {
        // 1. Essayer de récupérer le token depuis l'en-tête Authorization
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }
        
        // 2. Si pas dans l'en-tête, chercher dans les cookies
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("jwtToken".equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        
        return null;
    }
}