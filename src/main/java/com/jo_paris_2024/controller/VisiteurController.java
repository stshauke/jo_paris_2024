package com.jo_paris_2024.controller;

import com.jo_paris_2024.dto.ConnexionVisiteurDTO;
import com.jo_paris_2024.dto.VisiteurDTO;
import com.jo_paris_2024.service.VisiteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.jo_paris_2024.controller.ErrorResponse;  // Assurez-vous que le chemin est correct

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/visiteurs")
@CrossOrigin
public class VisiteurController {

    @Autowired
    private VisiteurService visiteurService;

    /**
     * Récupère un visiteur par son ID.
     */
    @GetMapping("/{idVisiteur}")
    public ResponseEntity<VisiteurDTO> getVisiteur(@PathVariable Long idVisiteur) {
        VisiteurDTO visiteurDTO = visiteurService.getVisiteur(idVisiteur);
        return ResponseEntity.ok(visiteurDTO);
    }

    /**
     * Récupère tous les visiteurs.
     */
    @GetMapping
    public ResponseEntity<List<VisiteurDTO>> getAllVisiteurs() {
        List<VisiteurDTO> visiteurs = visiteurService.getAllVisiteurs();
        return ResponseEntity.ok(visiteurs);
    }

    /**
     * Enregistre un nouveau visiteur.
     */
    @PostMapping("/saveVisiteur")
    public ResponseEntity<?> saveVisiteur(@Valid @RequestBody VisiteurDTO visiteurDTO) {
        try {
            // Enregistre le visiteur
            VisiteurDTO savedVisiteur = visiteurService.saveVisiteur(visiteurDTO);

            // Crée les en-têtes de réponse, notamment l'en-tête "Location"
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location", "/api/v1/visiteurs/" + savedVisiteur.getIdVisiteur());

            // Retourne la réponse avec le code HTTP 201 (Created)
            return new ResponseEntity<>(savedVisiteur, headers, HttpStatus.CREATED);
        } catch (Exception e) {
            // Capture l'exception et retourne une réponse d'erreur
            e.printStackTrace();
            ErrorResponse errorResponse = new ErrorResponse("Une erreur s'est produite : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    /**
     * Met à jour un visiteur existant.
     */
    @PutMapping
    public ResponseEntity<VisiteurDTO> updateVisiteur(@Valid @RequestBody VisiteurDTO visiteurDTO) {
        VisiteurDTO updatedVisiteur = visiteurService.updateVisiteur(visiteurDTO);
        return ResponseEntity.ok(updatedVisiteur);
    }

    /**
     * Supprime un visiteur par son ID.
     */
    @DeleteMapping("/{idVisiteur}")
    public ResponseEntity<Void> deleteVisiteur(@PathVariable Long idVisiteur) {
        visiteurService.deleteVisiteur(idVisiteur);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody ConnexionVisiteurDTO connexionvisiteurdto) {
        try {
            VisiteurDTO authenticatedVisiteur = visiteurService.authenticateVisiteur(
            		connexionvisiteurdto.getEmail(), 
            		connexionvisiteurdto.getPassword()
            );

            return ResponseEntity.ok(authenticatedVisiteur);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ErrorResponse(e.getMessage()));
        }
    }
    /**
     * Récupère la clé_unique d'un visiteur par son ID.
     */
    @GetMapping("/{id_visiteur}/cle")
    public String getCleVisiteurById(@PathVariable Long id_visiteur) {
        return visiteurService.getCleVisiteurById(id_visiteur);
    }

}
