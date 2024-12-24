package com.jo_paris_2024.service;

import com.jo_paris_2024.dto.PanierDTO;
import com.jo_paris_2024.entity.Panier;
import com.jo_paris_2024.repository.PanierRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class PanierService {

    @Autowired
    private PanierRepository panierRepository;

    public PanierDTO savePanier(PanierDTO panierDTO) {
        // Générer une clé unique pour le billet
        String cleBillet = UUID.randomUUID().toString();

        // Assigner la clé générée au DTO en utilisant le setter
        panierDTO.setIdentifiantBillet(cleBillet);  // Utiliser le setter pour l'attribuer

        // Créer une entité Panier à partir du DTO
        Panier panier = new Panier();
        panier.setId_visiteur(panierDTO.getIdVisiteur());
        panier.setId_billet(panierDTO.getIdBillet());
        panier.setIdentifiant_billet(panierDTO.getIdentifiantBillet());
        panier.setDate_ajout(panierDTO.getDateAjout());

        // Sauvegarder l'entité dans la base de données
        Panier savedPanier = panierRepository.save(panier);

        // Retourner un DTO à partir de l'entité sauvegardée
        return new PanierDTO(
            savedPanier.getId_panier(),
            savedPanier.getId_visiteur(),
            savedPanier.getId_billet(),
            savedPanier.getIdentifiant_billet(),
            savedPanier.getDate_ajout()
        );
    }

    // Ajouter plusieurs paniers
    public List<PanierDTO> savePanier(List<PanierDTO> panierDTOs) {
        return panierDTOs.stream()
                         .map(this::savePanier) // Appel de la méthode savePanier pour chaque PanierDTO
                         .collect(Collectors.toList());
    }

    // Récupérer tous les paniers
    public List<PanierDTO> getAllPaniers() {
        List<Panier> panierList = panierRepository.findAll();
        return panierList.stream()
                .map(panier -> new PanierDTO(
                        panier.getId_panier(),
                        panier.getId_visiteur(),
                        panier.getId_billet(),
                        panier.getIdentifiant_billet(),
                        panier.getDate_ajout()
                ))
                .collect(Collectors.toList());
    }

    // Récupérer un panier par ID
    public PanierDTO getPanier(Long panierId) {
        Panier panier = panierRepository.findById(panierId)
                .orElseThrow(() -> new RuntimeException("Panier non trouvé"));
        return new PanierDTO(
                panier.getId_panier(),
                panier.getId_visiteur(),
                panier.getId_billet(),
                panier.getIdentifiant_billet(),
                panier.getDate_ajout()
        );
    }

    // Mettre à jour un panier
    public PanierDTO updatePanier(PanierDTO panierDTO) {
        Panier panier = new Panier(
                panierDTO.getIdPanier(),
                panierDTO.getIdVisiteur(),
                panierDTO.getIdBillet(),
                panierDTO.getIdentifiantBillet(),
                panierDTO.getDateAjout()
        );
        panierRepository.save(panier);
        return panierDTO;
    }

    // Supprimer un panier
    public boolean deletePanier(PanierDTO panierDTO) {
        Panier panier = new Panier(
                panierDTO.getIdPanier(),
                panierDTO.getIdVisiteur(),
                panierDTO.getIdBillet(),
                panierDTO.getIdentifiantBillet(),
                panierDTO.getDateAjout()
        );
        panierRepository.delete(panier);
        return true;
    }
}
