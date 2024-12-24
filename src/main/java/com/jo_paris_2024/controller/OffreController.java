package com.jo_paris_2024.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
import com.jo_paris_2024.entity.Offre;
import com.jo_paris_2024.repository.OffreRepository;
import com.jo_paris_2024.service.OffreService;

@RestController
	@RequestMapping(value = "api/v1/offres")
	@CrossOrigin
public class OffreController {

	    @Autowired
	    private OffreService offreService;
	    @Autowired
	    private OffreRepository offreRepository;
	    
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
