package com.jo_paris_2024.service;

import com.jo_paris_2024.dto.StadeDTO;
import com.jo_paris_2024.dto.VisiteurDTO;
import com.jo_paris_2024.entity.Stade;
import com.jo_paris_2024.entity.Visiteur;
import com.jo_paris_2024.repository.VisiteurRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class VisiteurService {

    @Autowired
    private VisiteurRepository visiteurRepository;

    // Sauvegarde un visiteur
    public VisiteurDTO saveVisiteur(VisiteurDTO visiteurDTO) {
        Visiteur visiteur = new Visiteur(
                visiteurDTO.getId_visiteur(),
                visiteurDTO.getNom_visiteur(),
                visiteurDTO.getPrenom_visiteur(),
                visiteurDTO.getEmail_visiteur(),
                visiteurDTO.getPassword_visiteur(),
                visiteurDTO.getSolde_visiteur()
        );
        visiteurRepository.save(visiteur);
        return mapToDTO(visiteur);
    }

    // Récupère tous les visiteurs
    public List<VisiteurDTO> getAllVisiteurs() {
        List<Visiteur> visiteurs = visiteurRepository.findAll();
        return visiteurs.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Met à jour les informations d'un visiteur
    public VisiteurDTO updateVisiteur(VisiteurDTO visiteurDTO) {
        Visiteur visiteur = visiteurRepository.findById(visiteurDTO.getId_visiteur())
                .orElseThrow(() -> new RuntimeException("Visiteur not found"));
        
        visiteur.setNom_visiteur(visiteurDTO.getNom_visiteur());
        visiteur.setPrenom_visiteur(visiteurDTO.getPrenom_visiteur());
        visiteur.setEmail_visiteur(visiteurDTO.getEmail_visiteur());
        visiteur.setPassword_visiteur(visiteurDTO.getPassword_visiteur());
        visiteur.setSolde_visiteur(visiteurDTO.getSolde_visiteur());

        visiteurRepository.save(visiteur);
        return mapToDTO(visiteur);
    }

 // Supprime un stade
    /*public boolean deleteStade(StadeDTO stadeDTO) {
        Stade stade = new Stade(stadeDTO.getId_stade(), stadeDTO.getNom_stade(), stadeDTO.getAdresse_stade());
        stadeRepository.delete(stade);
        return true;
    }*/
    
    
    // Supprime un visiteur
    public boolean deleteVisiteur(VisiteurDTO visiteurDTO) {
    	 Visiteur visiteur = new Visiteur(visiteurDTO.getId_visiteur(),
    			 visiteurDTO.getNom_visiteur(), visiteurDTO.getPrenom_visiteur(),
    			 visiteurDTO.getEmail_visiteur(),visiteurDTO.getPassword_visiteur(),visiteurDTO.getSolde_visiteur());
         visiteurRepository.delete(visiteur);
        return true;
    }

    // Récupère un visiteur par son ID
    public VisiteurDTO getVisiteur(Long visiteurId) {
        Visiteur visiteur = visiteurRepository.findById(visiteurId)
                .orElseThrow(() -> new RuntimeException("Visiteur not found"));
        return mapToDTO(visiteur);
    }

    // Méthode utilitaire pour mapper une entité en DTO
    private VisiteurDTO mapToDTO(Visiteur visiteur) {
        return new VisiteurDTO(
                visiteur.getId_visiteur(),
                visiteur.getNom_visiteur(),
                visiteur.getPrenom_visiteur(),
                visiteur.getEmail_visiteur(),
                visiteur.getPassword_visiteur(),
                visiteur.getSolde_visiteur()
        );
    }
}
