package com.jo_paris_2024.controller;

import com.jo_paris_2024.dto.StadeDTO;
import com.jo_paris_2024.service.StadeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour la gestion des stades.
 * Fournit des endpoints permettant de récupérer, ajouter, modifier et supprimer des stades.
 */
@RestController
@RequestMapping(value = "api/v1/stades")
@CrossOrigin // Permet aux requêtes provenant d'autres domaines d'accéder à ces endpoints (ex: frontend)
public class StadeController {

    @Autowired
    private StadeService stadeService; // Service qui contient la logique métier des stades

    /**
     * Récupère les détails d'un stade spécifique à partir de son identifiant.
     *
     * @param id_stade L'identifiant unique du stade.
     * @return Un objet StadeDTO contenant les détails du stade correspondant.
     */
    @GetMapping("/{id_stade}")
    public StadeDTO getStade(@PathVariable Long id_stade) {
        return stadeService.getStade(id_stade);
    }

    /**
     * Récupère la liste de tous les stades disponibles.
     *
     * @return Une liste d'objets StadeDTO représentant tous les stades.
     */
    @GetMapping("/getAllStades")
    public List<StadeDTO> getAllStades() {
        return stadeService.getAllStades();
    }

    /**
     * Enregistre un nouveau stade dans la base de données.
     *
     * @param stadeDTO Objet contenant les informations du stade à sauvegarder.
     * @return Un objet StadeDTO contenant les informations du stade enregistré.
     */
    @PostMapping("/saveStade")
    public StadeDTO saveStade(@RequestBody StadeDTO stadeDTO) {
        return stadeService.saveStade(stadeDTO);
    }

    /**
     * Met à jour les informations d'un stade existant.
     *
     * @param stadeDTO Objet contenant les nouvelles informations du stade.
     * @return Un objet StadeDTO contenant les données mises à jour du stade.
     */
    @PutMapping("/updateStade")
    public StadeDTO updateStade(@RequestBody StadeDTO stadeDTO) {
        return stadeService.updateStade(stadeDTO);
    }

    /**
     * Supprime un stade en fonction des informations fournies.
     *
     * @param stadeDTO Objet contenant les détails du stade à supprimer.
     * @return true si la suppression a réussi, false sinon.
     */
    @DeleteMapping("/deleteStade")
    public boolean deleteStade(@RequestBody StadeDTO stadeDTO) {
        return stadeService.deleteStade(stadeDTO);
    }
}
