package com.jo_paris_2024.service;

import com.jo_paris_2024.dto.PanierDTO;
import com.jo_paris_2024.entity.Panier;
import com.jo_paris_2024.repository.PanierRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PanierService {

    @Autowired
    private PanierRepository panierRepository;

    // Ajouter un panier
    public PanierDTO savePanier(PanierDTO panierDTO) {
        Panier panier = new Panier(
                panierDTO.getIdPanier(),
                panierDTO.getIdVisiteur(),
                panierDTO.getIdBillet(),
                panierDTO.getQuantite(),
                panierDTO.getDateAjout()
        );
        panierRepository.save(panier);
        return panierDTO;
    }

    // Récupérer tous les paniers
    public List<PanierDTO> getAllPaniers() {
        List<Panier> panierList = panierRepository.findAll();
        return panierList.stream()
                .map(panier -> new PanierDTO(
                        panier.getId_panier(),
                        panier.getId_visiteur(),
                        panier.getId_billet(),
                        panier.getQuantite(),
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
                panier.getQuantite(),
                panier.getDate_ajout()
        );
    }

    // Mettre à jour un panier
    public PanierDTO updatePanier(PanierDTO panierDTO) {
        Panier panier = new Panier(
                panierDTO.getIdPanier(),
                panierDTO.getIdVisiteur(),
                panierDTO.getIdBillet(),
                panierDTO.getQuantite(),
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
                panierDTO.getQuantite(),
                panierDTO.getDateAjout()
        );
        panierRepository.delete(panier);
        return true;
    }
}
