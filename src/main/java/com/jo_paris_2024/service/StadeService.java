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

@Service
@Transactional
public class StadeService {

    @Autowired
    private StadeRepository stadeRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Enregistre un nouveau stade
    public StadeDTO saveStade(StadeDTO stadeDTO) {
        Stade stade = modelMapper.map(stadeDTO, Stade.class);
        stadeRepository.save(stade);
        return stadeDTO;
    }

    // Récupère la liste de tous les stades
    public List<StadeDTO> getAllStades() {
        List<Stade> stadeList = stadeRepository.findAll();
        return modelMapper.map(stadeList, new TypeToken<List<StadeDTO>>(){}.getType());
    }

    // Met à jour les informations d'un stade
    public StadeDTO updateStade(StadeDTO stadeDTO) {
        Stade stade = modelMapper.map(stadeDTO, Stade.class);
        stadeRepository.save(stade);
        return stadeDTO;
    }

    // Supprime un stade
    public boolean deleteStade(StadeDTO stadeDTO) {
        Stade stade = modelMapper.map(stadeDTO, Stade.class);
        stadeRepository.delete(stade);
        return true;
    }

    // Récupère un stade par son ID
    public StadeDTO getStade(Long stadeId) {
        Stade stade = stadeRepository.findById(stadeId)
                .orElseThrow(() -> new RuntimeException("Stade not found"));
        return modelMapper.map(stade, StadeDTO.class);
    }
}
