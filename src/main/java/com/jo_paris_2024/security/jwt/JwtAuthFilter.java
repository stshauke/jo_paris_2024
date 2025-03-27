package com.jo_paris_2024.security.jwt;

import com.jo_paris_2024.service.JwtService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    public JwtAuthFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        // Si l'en-tête Authorization est absent ou mal formé, on passe à la suite
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(7);  // Retire "Bearer " pour obtenir le token brut
        String email = jwtService.extractEmail(token); // Extraire l'email à partir du token
        try {
           

            // Si l'email est non null et que le token est valide, on ajoute l'authentification au contexte
        	if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
        	    if (jwtService.isTokenValid(token, email)) {
        	        UsernamePasswordAuthenticationToken authToken =
        	                new UsernamePasswordAuthenticationToken(email, null, List.of());
        	        SecurityContextHolder.getContext().setAuthentication(authToken);  // Authentifie l'utilisateur
        	    }
        	}
        } catch (ExpiredJwtException e) {
            // Si le token est expiré, on retourne une réponse 401 Unauthorized
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Le token est expiré.");
            return;  // On arrête l'exécution de la chaîne de filtres
        } catch (Exception e) {
            // Si une autre exception est levée (token mal formé, etc.), on retourne 401 Unauthorized
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token invalide.");
            return;
        }

        // On continue la chaîne de filtres (par exemple, pour que la requête arrive dans le contrôleur)
        filterChain.doFilter(request, response);
    }
}
