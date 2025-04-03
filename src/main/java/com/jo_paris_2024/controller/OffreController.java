package com.jo_paris_2024.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jo_paris_2024.dto.OffreDTO;
import com.jo_paris_2024.repository.OffreRepository;
import com.jo_paris_2024.service.OffreService;

/**
 * Contrôleur REST pour la gestion des offres.
 * Permet de récupérer, ajouter, mettre à jour et supprimer des offres.
 */
@RestController
@RequestMapping(value = "api/v1/offres")
@CrossOrigin // Permet l'accès depuis d'autres domaines (utile pour les appels frontend)
public class OffreController {

    @Autowired
    private OffreService offreService; // Service contenant la logique métier des offres

    @Autowired
    private OffreRepository offreRepository; // Repository pour accéder aux données de la base

    /**
     * Récupère une offre spécifique en fonction de son identifiant.
     *
     * @param id_offre L'identifiant unique de l'offre.
     * @return OffreDTO contenant les détails de l'offre.
     */
    @GetMapping("/{id_offre}")
    public OffreDTO getOffre(@PathVariable Long id_offre) {
        return offreService.getOffre(id_offre);
    }

    /**
     * Récupère la liste de toutes les offres disponibles.
     *
     * @return Liste d'objets OffreDTO représentant toutes les offres.
     */
    @GetMapping("/getAllOffres")
    public List<OffreDTO> getAllOffres() {
        return offreService.getAllOffres();
    }

    /**
     * Enregistre une nouvelle offre dans la base de données.
     *
     * @param offreDTO Objet contenant les informations de l'offre à sauvegarder.
     * @return OffreDTO contenant les informations de l'offre enregistrée.
     */
    @PostMapping("/saveOffre")
    public OffreDTO saveOffre(@RequestBody OffreDTO offreDTO) {
        return offreService.saveOffre(offreDTO);
    }

    /**
     * Met à jour une offre existante.
     *
     * @param offreDTO Objet contenant les nouvelles informations de l'offre.
     * @return OffreDTO contenant les informations mises à jour de l'offre.
     */
    @PutMapping("/updateOffre")
    public OffreDTO updateOffre(@RequestBody OffreDTO offreDTO) {
        return offreService.updateOffre(offreDTO);
    }

    /**
     * Supprime une offre en fonction des informations fournies.
     *
     * @param offreDTO Objet contenant les détails de l'offre à supprimer.
     * @return true si l'offre a été supprimée avec succès, false sinon.
     */
    @DeleteMapping("/deleteOffre")
    public boolean deleteOffre(@RequestBody OffreDTO offreDTO) {
        return offreService.deleteOffre(offreDTO);
    }

    /**
     * Récupère une liste contenant les identifiants et les noms de toutes les offres.
     * Utile pour les menus déroulants ou les sélections rapides.
     *
     * @return Liste de maps contenant les paires id_offre - nom_offre.
     */
    @GetMapping("/getAllIdsAndNames")
    public List<Map<String, Object>> getAllIdsAndNames() {
        return offreRepository.findAll()
                .stream()
                .map(offre -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("id_offre", offre.getId_offre());
                    map.put("nom_offre", offre.getNom_offre());
                    return map;
                })
                .collect(Collectors.toList());
    }
}
