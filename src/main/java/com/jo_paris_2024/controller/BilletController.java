package com.jo_paris_2024.controller;

import com.jo_paris_2024.dto.BilletDTO;
import com.jo_paris_2024.service.BilletService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/billets")
@CrossOrigin
public class BilletController {

    @Autowired
    private BilletService billetService;

    // Récupérer un billet par son ID
    @GetMapping("/{id_billet}")
    public BilletDTO getBillet(@PathVariable Long id_billet) {
        return billetService.getBillet(id_billet);
    }
    
    // Récupérer tous les billets
    @GetMapping("/getAllBillets")
    public List<BilletDTO> getAllBillets() {
        return billetService.getAllBillets();
    }

    // Ajouter un nouveau billet
    @PostMapping("/saveBillet")
    public BilletDTO saveBillet(@RequestBody BilletDTO billetDTO) {
        return billetService.saveBillet(billetDTO);
    }
    
    // Mettre à jour un billet
    @PutMapping("/updateBillet")
    public BilletDTO updateBillet(@RequestBody BilletDTO billetDTO) {
        return billetService.updateBillet(billetDTO);
    }

    // Supprimer un billet
    @DeleteMapping("/deleteBillet")
    public boolean deleteBillet(@RequestBody BilletDTO billetDTO) {
        return billetService.deleteBillet(billetDTO);
    }
}
