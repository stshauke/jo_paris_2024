package com.jo_paris_2024.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.jo_paris_2024.entity.Offre;
import com.jo_paris_2024.entity.Stade;

public interface OffreRepository extends JpaRepository<Offre, Long> {
	

}
