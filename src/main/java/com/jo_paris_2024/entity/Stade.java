package com.jo_paris_2024.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Stade {
    @Id
    private Long idStade;
    private String nomStade;
    private String adresseStade;
}
