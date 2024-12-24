package com.jo_paris_2024.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jo_paris_2024.dto.OffreDTO;
import com.jo_paris_2024.dto.StadeDTO;
import com.jo_paris_2024.entity.Offre;
import com.jo_paris_2024.entity.Stade;
import com.jo_paris_2024.repository.OffreRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OffreService {
    @Autowired
    private OffreRepository offreRepository;

    public OffreDTO saveOffre(OffreDTO offreDTO) {
        Offre offre = new Offre(offreDTO.getId_offre(), offreDTO.getNom_offre(), offreDTO.getDescription_offre(),
        		offreDTO.getPrix_offre(),offreDTO.getNombre_personnes(),offreDTO.getDate_fin_offre());
        offreRepository.save(offre);
        return offreDTO;
    }
    
 // Récupère la liste de tous les offres
    public List<OffreDTO> getAllOffres() {
        List<Offre> offreList = offreRepository.findAll();
        return offreList.stream()
                        .map(offre -> new OffreDTO(offre.getId_offre(), offre.getNom_offre(), offre.getDescription_offre(),
                        		offre.getPrix_offre(),offre.getNombre_personnes(),offre.getDate_fin_offre())) // Corrected here
                        .collect(Collectors.toList());
    }
    // Met à jour les informations d'une offre
    public OffreDTO updateOffre(OffreDTO offreDTO) {
        Offre offre = new Offre(offreDTO.getId_offre(), offreDTO.getNom_offre(), offreDTO.getDescription_offre(),
        		offreDTO.getPrix_offre(),offreDTO.getNombre_personnes(),offreDTO.getDate_fin_offre());
        offreRepository.save(offre);
        return offreDTO;
    }

    // Supprime une offre
    public boolean deleteOffre(OffreDTO offreDTO) {
        Offre offre = new Offre(offreDTO.getId_offre(), offreDTO.getNom_offre(), offreDTO.getDescription_offre(),
        		offreDTO.getPrix_offre(),offreDTO.getNombre_personnes(),offreDTO.getDate_fin_offre());
        offreRepository.delete(offre);
        return true;
    }

 // Récupère une offre par son ID
    public OffreDTO getOffre(Long offreId) {
        Offre offre = offreRepository.findById(offreId)
                .orElseThrow(() -> new RuntimeException("Offre non trouvée"));
        // Mapper les propriétés de l'entité Stade vers un DTO
        return new OffreDTO(offre.getId_offre(), offre.getNom_offre(), offre.getDescription_offre(),
        		offre.getPrix_offre(),offre.getNombre_personnes(),offre.getDate_fin_offre());
    }

}

