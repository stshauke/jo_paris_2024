package com.jo_paris_2024.service;

import com.jo_paris_2024.dto.VisiteurDTO;
import com.jo_paris_2024.entity.Visiteur;
import com.jo_paris_2024.repository.VisiteurRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class VisiteurService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private VisiteurRepository visiteurRepository;

    // Sauvegarde un visiteur
    public VisiteurDTO saveVisiteur(VisiteurDTO visiteurDTO) {
    	// Générer une clé unique pour le visiteur
        String cleVisiteur = UUID.randomUUID().toString();
        visiteurDTO.setCleVisiteur(cleVisiteur);  // Assigner la clé générée au DTO
    	System.out.println("Email tenté : " + visiteurDTO.getEmailVisiteur());
        // Vérification de l'unicité de l'email
        if (visiteurRepository.existsByEmailVisiteur(visiteurDTO.getEmailVisiteur())) {
            throw new RuntimeException("Un visiteur avec cet email existe déjà.");
        }
        if (visiteurDTO.getPasswordVisiteur() == null) {
            throw new IllegalArgumentException("rawPassword cannot be null");
        }
        // Hachage du mot de passe
        String hashedPassword = passwordEncoder.encode(visiteurDTO.getPasswordVisiteur());

        // Création de l'entité Visiteur
        Visiteur visiteur = new Visiteur(
                null, // L'ID est généré automatiquement
                visiteurDTO.getNomVisiteur(),
                visiteurDTO.getPrenomVisiteur(),
                visiteurDTO.getEmailVisiteur(),
                hashedPassword, // Mot de passe haché
                visiteurDTO.getSoldeVisiteur(),
                visiteurDTO.getCleVisiteur()
        );

        // Sauvegarde en base
        visiteurRepository.save(visiteur);
        return mapToDTO(visiteur);
    }

    // Récupère tous les visiteurs
    public List<VisiteurDTO> getAllVisiteurs() {
        return visiteurRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Met à jour les informations d'un visiteur
    public VisiteurDTO updateVisiteur(VisiteurDTO visiteurDTO) {
        Visiteur visiteur = visiteurRepository.findById(visiteurDTO.getIdVisiteur())
                .orElseThrow(() -> new RuntimeException("Visiteur introuvable"));

        // Vérification de l'unicité de l'email (sauf si c'est l'email du visiteur actuel)
        if (!visiteur.getEmail_visiteur().equals(visiteurDTO.getEmailVisiteur()) &&
                visiteurRepository.existsByEmailVisiteur(visiteurDTO.getEmailVisiteur())) {
            throw new RuntimeException("Un visiteur avec cet email existe déjà.");
        }

        // Mise à jour des champs
        visiteur.setNom_visiteur(visiteurDTO.getNomVisiteur());
        visiteur.setPrenom_visiteur(visiteurDTO.getPrenomVisiteur());
        visiteur.setEmail_visiteur(visiteurDTO.getEmailVisiteur());

        // Mise à jour du mot de passe si fourni
        if (visiteurDTO.getPasswordVisiteur() != null && !visiteurDTO.getPasswordVisiteur().isBlank()) {
            visiteur.setPassword_visiteur(passwordEncoder.encode(visiteurDTO.getPasswordVisiteur()));
        }

        visiteur.setSolde_visiteur(visiteurDTO.getSoldeVisiteur());
        visiteur.setCle_visiteur(visiteurDTO.getCleVisiteur());

        // Sauvegarde en base
        visiteurRepository.save(visiteur);
        return mapToDTO(visiteur);
    }

    // Supprime un visiteur par son ID
    public boolean deleteVisiteur(Long visiteurId) {
        if (!visiteurRepository.existsById(visiteurId)) {
            throw new RuntimeException("Visiteur introuvable");
        }
        visiteurRepository.deleteById(visiteurId);
        return true;
    }

    // Récupère un visiteur par son ID
    public VisiteurDTO getVisiteur(Long visiteurId) {
        Visiteur visiteur = visiteurRepository.findById(visiteurId)
                .orElseThrow(() -> new RuntimeException("Visiteur introuvable"));
        return mapToDTO(visiteur);
    }

    // Méthode utilitaire pour mapper une entité en DTO
    private VisiteurDTO mapToDTO(Visiteur visiteur) {
        return new VisiteurDTO(
                visiteur.getId_visiteur(),
                visiteur.getNom_visiteur(),
                visiteur.getPrenom_visiteur(),
                visiteur.getEmail_visiteur(),
                null, // Le mot de passe n'est pas renvoyé pour des raisons de sécurité
                visiteur.getSolde_visiteur(),
                visiteur.getCle_visiteur()
        );
    }
    public VisiteurDTO authenticateVisiteur(String email, String password) {
        // Recherche du visiteur par email
        Visiteur visiteur = visiteurRepository.findByEmailVisiteur(email)
                .orElseThrow(() -> new RuntimeException("Email ou mot de passe incorrect"));

        // Vérification du mot de passe
        if (!passwordEncoder.matches(password, visiteur.getPassword_visiteur())) {
            throw new RuntimeException("Email ou mot de passe incorrect");
        }

        // Retourne le DTO sans exposer le mot de passe
        return mapToDTO(visiteur);
    }
 // Récupère la clé unique d'un visiteur par son ID
    public String getCleVisiteurById(Long visiteurId) {
        Visiteur visiteur = visiteurRepository.findById(visiteurId)
                .orElseThrow(() -> new RuntimeException("Visiteur introuvable avec l'ID : " + visiteurId));
        return visiteur.getCle_visiteur(); // Retourne la clé unique
    }

}
