package com.jo_paris_2024.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jo_paris_2024.dto.OffreDTO;
import com.jo_paris_2024.service.OffreService;

@RestController
	@RequestMapping(value = "api/v1/offres")
	@CrossOrigin
public class OffreController {

	    @Autowired
	    private OffreService offreService;

	    @GetMapping("/{id_offre}")
	    public OffreDTO getOffre(@PathVariable Long id_offre) {
	        return offreService.getOffre(id_offre);
	    }
	    
	    @GetMapping("/getAllOffres")
	    public List<OffreDTO> getAllOffres() {
	        return offreService.getAllOffres();
	    }

	    @PostMapping("/saveOffre")
	    public OffreDTO saveOffre(@RequestBody OffreDTO offreDTO) {
	        return offreService.saveOffre(offreDTO);
	    }
	    
	    @PutMapping("/updateOffre")
	    public OffreDTO updateOffre(@RequestBody OffreDTO offreDTO) {
	        return offreService.updateOffre(offreDTO);
	    }

	    @DeleteMapping("/deleteOffre")
	    public boolean deleteOffre(@RequestBody OffreDTO offreDTO) {
	        return offreService.deleteOffre(offreDTO);
	    }
	}
