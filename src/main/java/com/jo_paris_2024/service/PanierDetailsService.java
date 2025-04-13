package com.jo_paris_2024.service;

import com.jo_paris_2024.dto.PanierDetailsDTO;
import com.jo_paris_2024.repository.PanierDetailsProjection;
import com.jo_paris_2024.repository.PanierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PanierDetailsService {

    @Autowired
    private PanierRepository panierRepository;

    public List<PanierDetailsDTO> getAllPanierDetails() {
        List<PanierDetailsProjection> projections = panierRepository.findAllPanierDetailsNative();

        return projections.stream()
                .map(projection -> new PanierDetailsDTO(
                        projection.getIdPanier(),
                        projection.getIdVisiteur(),
                        projection.getNomVisiteur(),
                        projection.getEmailVisiteur(),
                        projection.getIdBillet(),
                        projection.getNomBillet(),
                        projection.getQuantite(),
                        projection.getPrix()
                ))
                .collect(Collectors.toList());
    }

    // ✅ Méthode pour compter le nombre total de billets achetés avec la requête native
    public long getTotalBilletsAchetes() {
        return getAllPanierDetails().stream()
                .mapToLong(PanierDetailsDTO::getQuantite)
                .sum();
    }

    // ✅ Méthode pour calculer le total des montants avec la requête native
    public double getTotalMontantBillets() {
        return getAllPanierDetails().stream()
                .mapToDouble(dto -> dto.getPrix() * dto.getQuantite())
                .sum();
    }
}
