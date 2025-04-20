package com.jo_paris_2024.controller;

import com.jo_paris_2024.dto.PanierDetailsDTO;
import com.jo_paris_2024.service.PanierDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/paniers")
@CrossOrigin(origins = "*") // Optionnel : accepte les requêtes de tous les domaines pour le front
public class PanierDetailsController {

    private final PanierDetailsService panierDetailsService;

    // Constructor injection (plus clean que @Autowired sur le champ)
    public PanierDetailsController(PanierDetailsService panierDetailsService) {
        this.panierDetailsService = panierDetailsService;
    }

    // Récupérer la liste détaillée des billets achetés
    @GetMapping("/details")
    public List<PanierDetailsDTO> getAllPanierDetails() {
        return panierDetailsService.getAllPanierDetails();
    }

    // Nombre total de billets achetés
    @GetMapping("/details/total-billets")
    public long getTotalBilletsAchetes() {
        return panierDetailsService.getTotalBilletsAchetes();
    }

    // Total du montant des billets achetés
    @GetMapping("/details/total-montant")
    public double getTotalMontantBillets() {
        return panierDetailsService.getTotalMontantBillets();
    }
}
