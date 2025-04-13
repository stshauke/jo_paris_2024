package com.jo_paris_2024.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jo_paris_2024.entity.Panier;

import java.util.List;
import java.util.Map;

public interface PanierRepository extends JpaRepository<Panier, Long> {

    @Query(value = "SELECT p.id_panier as idPanier, " +
                   "v.id_visiteur as idVisiteur, " +
                   "CONCAT(v.nom_visiteur, ' ', v.prenom_visiteur) as nomVisiteur, " +
                   "v.email_visiteur as emailVisiteur, " +
                   "b.id_billet as idBillet, " +
                   "b.type_billet as nomBillet, " +
                   "p.quantite as quantite, " +
                   "p.prix as prix " +
                   "FROM panier p " +
                   "JOIN visiteur v ON v.id_visiteur = p.id_visiteur " +
                   "JOIN billet b ON p.id_billet = b.id_billet", 
           nativeQuery = true)
    List<PanierDetailsProjection> findAllPanierDetailsNative();
}
