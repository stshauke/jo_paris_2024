package com.jo_paris_2024.controller;

import com.jo_paris_2024.dto.StadeDTO;
import com.jo_paris_2024.service.StadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/stades")
@CrossOrigin
public class StadeController {

    @Autowired
    private StadeService stadeService;

    @GetMapping("/{id_stade}")
    public StadeDTO getStade(@PathVariable Long id_stade) {
        return stadeService.getStade(id_stade);
    }
    
    @GetMapping("/getAllStades")
    public List<StadeDTO> getAllStades() {
        return stadeService.getAllStades();
    }

    @PostMapping("/saveStade")
    public StadeDTO saveStade(@RequestBody StadeDTO stadeDTO) {
        return stadeService.saveStade(stadeDTO);
    }

    @PutMapping("/updateStade")
    public StadeDTO updateStade(@RequestBody StadeDTO stadeDTO) {
        return stadeService.updateStade(stadeDTO);
    }

    @DeleteMapping("/deleteStade")
    public boolean deleteStade(@RequestBody StadeDTO stadeDTO) {
        return stadeService.deleteStade(stadeDTO);
    }
}
