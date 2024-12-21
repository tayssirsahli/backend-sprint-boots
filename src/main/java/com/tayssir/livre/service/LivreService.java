package com.tayssir.livre.service;

import java.util.List;

import com.tayssir.livre.entities.Livre;
import com.tayssir.livre.entities.Auteur;

public interface LivreService {

    Livre saveLivre(Livre livre);
    Livre updateLivre(Livre livre);
    void deleteLivre(Livre livre);
    void deleteLivreById(Long id);
    Livre getLivre(Long id);
    List<Livre> getAllLivres();
    List<Livre> findByNomLivre(String nomLivre);
    List<Livre> findByNomLivreContains(String nomLivre);
    List<Livre> findByAuteur(Auteur auteur);
    List<Livre> findByAuteur_IdAuteur(long idAuteur);
    List<Livre> findByOrderByNomLivreAsc();
    List<Livre> trierLivresNomsPrix();
}
