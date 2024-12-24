package com.jo_paris_2024.controller;

import com.jo_paris_2024.dto.PanierDTO;
import com.jo_paris_2024.service.PanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/paniers")
@CrossOrigin
public class PanierController {

    @Autowired
    private PanierService panierService;

    // Récupérer un panier par ID
    @GetMapping("/{id_panier}")
    public PanierDTO getPanier(@PathVariable Long id_panier) {
        return panierService.getPanier(id_panier);
    }

    // Récupérer tous les paniers
    @GetMapping("/getAllPaniers")
    public List<PanierDTO> getAllPaniers() {
        return panierService.getAllPaniers();
    }

    // Ajouter un panier
    @PostMapping("/savePanier")
    public List<PanierDTO> savePanier(@RequestBody List<PanierDTO> panierDTOs) {
        return panierService.savePanier(panierDTOs);
    }

    // Mettre à jour un panier
    @PutMapping("/updatePanier")
    public PanierDTO updatePanier(@RequestBody PanierDTO panierDTO) {
        return panierService.updatePanier(panierDTO);
    }

    // Supprimer un panier
    @DeleteMapping("/deletePanier")
    public boolean deletePanier(@RequestBody PanierDTO panierDTO) {
        return panierService.deletePanier(panierDTO);
    }
}
