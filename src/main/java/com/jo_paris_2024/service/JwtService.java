package com.jo_paris_2024.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtService {

    // Charger la clé secrète depuis le fichier de configuration (application.properties ou secrets.properties)
    @Value("${jwt.secret}")
    private String SECRET_KEY; // La clé secrète peut être injectée depuis un fichier de configuration sécurisé

    // Méthode pour extraire l'email (sujet) du token
    public String extractEmail(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // Méthode générique pour extraire une réclamation spécifique
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // Méthode pour générer un token JWT
    public String generateToken(String email) {
        String token = Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 120))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
        System.out.println("Token généré : " + token);
        System.out.println("⏳ Expiration du token : " + extractClaim(token, Claims::getExpiration));

        return token;
    }

    // Méthode pour vérifier la validité du token
    public boolean isTokenValid(String token, String email) {
        return email.equals(extractEmail(token)) && !isTokenExpired(token);
    }

    // Méthode pour vérifier si le token est expiré
    private boolean isTokenExpired(String token) {
    	 Date expiration = extractClaim(token, Claims::getExpiration);
    	    System.out.println("⏳ Expiration du token : " + expiration);
    	    System.out.println("⏰ Heure actuelle : " + new Date());
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }

    // Méthode pour extraire toutes les réclamations du token
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // Méthode pour obtenir la clé secrète de signature
    private Key getSigningKey() {
        byte[] keyBytes = Base64.getDecoder().decode(SECRET_KEY); // Si vous stockez la clé en base64, décodez-la ici
        return Keys.hmacShaKeyFor(keyBytes);
    }
    public boolean validateToken(String token, String email) {
        // Vérifie si le token est valide en comparant l'email et l'expiration
        return isTokenValid(token, email);
    }

}
