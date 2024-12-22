package com.jo_paris_2024.service;


import com.jo_paris_2024.dto.StadeDTO;
import com.jo_paris_2024.entity.Stade;
import com.jo_paris_2024.repository.StadeRepository;


import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StadeService {
    @Autowired
    private StadeRepository stadeRepository;

    public StadeDTO saveStade(StadeDTO stadeDTO) {
        Stade stade = new Stade(stadeDTO.getId_stade(), stadeDTO.getNom_stade(), stadeDTO.getAdresse_stade());
        stadeRepository.save(stade);
        return stadeDTO;
    }

  
    
    
    
    
 // Récupère la liste de tous les stades
    public List<StadeDTO> getAllStades() {
        List<Stade> stadeList = stadeRepository.findAll();
        return stadeList.stream()
                        .map(stade -> new StadeDTO(stade.getId_stade(), stade.getNom_stade(), stade.getAdresse_stade())) // Corrected here
                        .collect(Collectors.toList());
    }
    // Met à jour les informations d'un stade
    public StadeDTO updateStade(StadeDTO stadeDTO) {
        Stade stade = new Stade(stadeDTO.getId_stade(), stadeDTO.getNom_stade(), stadeDTO.getAdresse_stade());
        stadeRepository.save(stade);
        return stadeDTO;
    }

    // Supprime un stade
    public boolean deleteStade(StadeDTO stadeDTO) {
        Stade stade = new Stade(stadeDTO.getId_stade(), stadeDTO.getNom_stade(), stadeDTO.getAdresse_stade());
        stadeRepository.delete(stade);
        return true;
    }

 // Récupère un stade par son ID
    public StadeDTO getStade(Long stadeId) {
        Stade stade = stadeRepository.findById(stadeId)
                .orElseThrow(() -> new RuntimeException("Stade non trouvé"));
        // Mapper les propriétés de l'entité Stade vers un DTO
        return new StadeDTO(stade.getId_stade(), stade.getNom_stade(), stade.getAdresse_stade());
    }

}
