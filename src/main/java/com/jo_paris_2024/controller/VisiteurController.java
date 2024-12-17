package com.jo_paris_2024.controller;

import com.jo_paris_2024.dto.VisiteurDTO;
import com.jo_paris_2024.service.VisiteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/visiteurs")
@CrossOrigin
public class VisiteurController {

    @Autowired
    private VisiteurService visiteurService;

    @GetMapping("/{id_visiteur}")
    public VisiteurDTO getVisiteur(@PathVariable Long id_visiteur) {
        return visiteurService.getVisiteur(id_visiteur);
    }

    @GetMapping("/getAllVisiteurs")
    public List<VisiteurDTO> getAllVisiteurs() {
        return visiteurService.getAllVisiteurs();
    }

    @PostMapping("/saveVisiteur")
    public VisiteurDTO saveVisiteur(@RequestBody VisiteurDTO visiteurDTO) {
        return visiteurService.saveVisiteur(visiteurDTO);
    }

    @PutMapping("/updateVisiteur")
    public VisiteurDTO updateVisiteur(@RequestBody VisiteurDTO visiteurDTO) {
        return visiteurService.updateVisiteur(visiteurDTO);
    }

    @DeleteMapping("/deleteVisiteur")
    public boolean deleteVisiteur(@RequestBody VisiteurDTO visiteurDTO) {
        return visiteurService.deleteVisiteur(visiteurDTO);
    }
}
