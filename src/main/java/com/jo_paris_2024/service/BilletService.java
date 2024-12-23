package com.jo_paris_2024.service;

import com.jo_paris_2024.dto.BilletDTO;
import com.jo_paris_2024.entity.Billet;
import com.jo_paris_2024.repository.BilletRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BilletService {

    @Autowired
    private BilletRepository billetRepository;

    // Ajouter un billet
    public BilletDTO saveBillet(BilletDTO billetDTO) {
        Billet billet = new Billet(
                billetDTO.getId_billet(),
                billetDTO.getId_offre(),
                billetDTO.getType_billet(),
                billetDTO.getPrix_billet(),
                billetDTO.getStock()
        );
        billetRepository.save(billet);
        return billetDTO;
    }

    // Récupérer tous les billets
    public List<BilletDTO> getAllBillets() {
        List<Billet> billetList = billetRepository.findAll();
        return billetList.stream()
                .map(billet -> new BilletDTO(
                        billet.getId_billet(),
                        billet.getId_offre(),
                        billet.getType_billet(),
                        billet.getPrix_billet(),
                        billet.getStock()
                ))
                .collect(Collectors.toList());
    }

    // Récupérer un billet par ID
    public BilletDTO getBillet(Long billetId) {
        Billet billet = billetRepository.findById(billetId)
                .orElseThrow(() -> new RuntimeException("Billet non trouvé"));
        return new BilletDTO(
                billet.getId_billet(),
                billet.getId_offre(),
                billet.getType_billet(),
                billet.getPrix_billet(),
                billet.getStock()
        );
    }

    // Mettre à jour un billet
    public BilletDTO updateBillet(BilletDTO billetDTO) {
        Billet billet = new Billet(
                billetDTO.getId_billet(),
                billetDTO.getId_offre(),
                billetDTO.getType_billet(),
                billetDTO.getPrix_billet(),
                billetDTO.getStock()
        );
        billetRepository.save(billet);
        return billetDTO;
    }

    // Supprimer un billet
    public boolean deleteBillet(BilletDTO billetDTO) {
        Billet billet = new Billet(
                billetDTO.getId_billet(),
                billetDTO.getId_offre(),
                billetDTO.getType_billet(),
                billetDTO.getPrix_billet(),
                billetDTO.getStock()
        );
        billetRepository.delete(billet);
        return true;
    }
}
