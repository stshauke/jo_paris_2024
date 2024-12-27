package com.jo_paris_2024.service;

import com.jo_paris_2024.dto.PanierDTO;
import com.jo_paris_2024.entity.Billet;
import com.jo_paris_2024.entity.Panier;
import com.jo_paris_2024.entity.Visiteur;
import com.jo_paris_2024.repository.BilletRepository;
import com.jo_paris_2024.repository.PanierRepository;
import com.jo_paris_2024.repository.VisiteurRepository;
import com.jo_paris_2024.utils.QRCodeGenerator;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class PanierService {

    @Autowired
    private PanierRepository panierRepository;
    @Autowired
    private BilletRepository billetRepository;
    @Autowired
    private VisiteurRepository visiteurRepository;
    
    public PanierDTO savePanier(PanierDTO panierDTO) {
    	//Vérifier si le billet existe dans la base de données
    	Optional<Billet> billetOptional =billetRepository.findById(Long.valueOf(panierDTO.getIdBillet()));
    	if(billetOptional.isEmpty()) {
    		throw new EntityNotFoundException("Billet non trouvé pour l'ID : "+panierDTO.getIdentifiantBillet());
    	}
    	Billet billet =billetOptional.get();
    	//Vérifier si le stock est suffisant
    	if(billet.getStock()<=0) {
    		throw new IllegalStateException("Stock insuffisant pour le billet ID:"
    				+billet.getId_billet());
    	}
    	//Reduire le stock du billet
    	billet.setStock(billet.getStock()-1);
    	billetRepository.save(billet);
    	
        // Générer une clé unique pour le billet
        String cleBillet = UUID.randomUUID().toString();

        // Assigner la clé générée au DTO en utilisant le setter
        panierDTO.setIdentifiantBillet(cleBillet);  // Utiliser le setter pour l'attribuer
        //Récupérer la clé attribuée au visiteur lors de son inscription
        Integer visiteurId=panierDTO.getIdVisiteur();
        //Integer visiteurId=12;
        //Recherche du visiteur par Id
        Visiteur visiteur=visiteurRepository.findById(Long.valueOf(visiteurId))
        		.orElseThrow(()->new EntityNotFoundException("Visiteur non trouvé pour l'Id :"+visiteurId));
        //Récupérer la clé unique du visiteur
        String cleVisiteur=visiteur.getCle_visiteur();
        //Afficher la clé trouvé
        System.out.println("Clé unique du visiteur:"+visiteurId+") :"+ cleVisiteur);
        //Concaténer la clé du visiteur et la clé du billet pour générer la cle_Unique
        String cleUnique=cleVisiteur+"_"+cleBillet;
        //Afficher ou vérifier la concaténation
        System.out.println("Clé Unique: "+cleUnique);
        
        //Créer le qr code 
        byte[] qrCodeBytes;
        try {
        	qrCodeBytes= QRCodeGenerator.generateQRCodeAsBytes(cleUnique, 200,200);
        	//Vérifier si QR est bien généré
        	if(qrCodeBytes==null|| qrCodeBytes.length==0) {
        		throw new RuntimeException("Qr Code non généré ou vide.");
        	}
        	System.out.println("QR Code généré avec succès. Taille :"+ qrCodeBytes.length+ " KO");
        }catch (Exception e) {
        	throw new RuntimeException("Erreur lors de la génération du QR code.");
        }
        
        
        
        
        // Créer une entité Panier à partir du DTO
        Panier panier = new Panier();
        panier.setId_visiteur(panierDTO.getIdVisiteur());
        panier.setId_billet(panierDTO.getIdBillet());
        panier.setIdentifiant_billet(panierDTO.getIdentifiantBillet());
        panier.setDate_ajout(panierDTO.getDateAjout());
          panier.setCle_unique(cleUnique);
          panier.setQr_code_image(qrCodeBytes);

        // Sauvegarder l'entité dans la base de données
        Panier savedPanier = panierRepository.save(panier);

        // Retourner un DTO à partir de l'entité sauvegardée
        return new PanierDTO(
            savedPanier.getId_panier(),
            savedPanier.getId_visiteur(),
            savedPanier.getId_billet(),
            savedPanier.getIdentifiant_billet(),
            savedPanier.getDate_ajout(),
             savedPanier.getCle_unique(),
             savedPanier.getQr_code_image()
        );
    }

    // Ajouter plusieurs paniers
    public List<PanierDTO> savePanier(List<PanierDTO> panierDTOs) {
        return panierDTOs.stream()
                         .map(this::savePanier) // Appel de la méthode savePanier pour chaque PanierDTO
                         .collect(Collectors.toList());
    }

    // Récupérer tous les paniers
    public List<PanierDTO> getAllPaniers() {
        List<Panier> panierList = panierRepository.findAll();
        return panierList.stream()
                .map(panier -> new PanierDTO(
                        panier.getId_panier(),
                        panier.getId_visiteur(),
                        panier.getId_billet(),
                        panier.getIdentifiant_billet(),
                        panier.getDate_ajout(),
                        panier.getCle_unique(),
                        panier.getQr_code_image()
                ))
                .collect(Collectors.toList());
    }

    // Récupérer un panier par ID
    public PanierDTO getPanier(Long panierId) {
        Panier panier = panierRepository.findById(panierId)
                .orElseThrow(() -> new RuntimeException("Panier non trouvé"));
        return new PanierDTO(
                panier.getId_panier(),
                panier.getId_visiteur(),
                panier.getId_billet(),
                panier.getIdentifiant_billet(),
                panier.getDate_ajout(),
                panier.getCle_unique(),
                panier.getQr_code_image()
        );
    }

    // Mettre à jour un panier
    public PanierDTO updatePanier(PanierDTO panierDTO) {
        Panier panier = new Panier(
                panierDTO.getIdPanier(),
                panierDTO.getIdVisiteur(),
                panierDTO.getIdBillet(),
                panierDTO.getIdentifiantBillet(),
                panierDTO.getDateAjout(),
                panierDTO.getCleUnique(),
                panierDTO.getQrCodeImage()
        );
        panierRepository.save(panier);
        return panierDTO;
    }

    // Supprimer un panier
    public boolean deletePanier(PanierDTO panierDTO) {
        Panier panier = new Panier(
                panierDTO.getIdPanier(),
                panierDTO.getIdVisiteur(),
                panierDTO.getIdBillet(),
                panierDTO.getIdentifiantBillet(),
                panierDTO.getDateAjout(),
                panierDTO.getCleUnique(),
                panierDTO.getQrCodeImage()
                
        );
        panierRepository.delete(panier);
        return true;
    }
}
