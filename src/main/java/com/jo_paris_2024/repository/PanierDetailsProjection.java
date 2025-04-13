package com.jo_paris_2024.repository;

public interface PanierDetailsProjection {
    Long getIdPanier();
    Long getIdVisiteur();
    String getNomVisiteur();
    String getEmailVisiteur();
    Long getIdBillet();
    String getNomBillet();
    Integer getQuantite();
    Double getPrix();
}
