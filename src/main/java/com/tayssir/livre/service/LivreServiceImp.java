package com.tayssir.livre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tayssir.livre.entities.Livre;
import com.tayssir.livre.entities.Auteur;
import com.tayssir.livre.repos.LivreRepository;

@Service
public class LivreServiceImp implements LivreService {

    @Autowired
    LivreRepository livreRepository;

    @Override
    public Livre saveLivre(Livre livre) {
        return livreRepository.save(livre);
    }

    @Override
    public Livre updateLivre(Livre livre) {
        return livreRepository.save(livre);
    }

    @Override
    public void deleteLivre(Livre livre) {
        livreRepository.delete(livre);
    }

    @Override
    public void deleteLivreById(Long id) {
        livreRepository.deleteById(id);
    }

    @Override
    public Livre getLivre(Long id) {
        return livreRepository.findById(id).orElse(null);
    }

    @Override
    public List<Livre> getAllLivres() {
        return livreRepository.findAll();
    }

    @Override
    public List<Livre> findByNomLivre(String nomLivre) {
        return livreRepository.findByNomLivre(nomLivre);
    }

    @Override
    public List<Livre> findByNomLivreContains(String nomLivre) {
        return livreRepository.findByNomLivreContains(nomLivre);
    }

    @Override
    public List<Livre> findByAuteur(Auteur auteur) {
        return livreRepository.findByAuteur(auteur);
    }

    @Override
    public List<Livre> findByAuteur_IdAuteur(long idAuteur) {
        return livreRepository.findByAuteur_IdAuteur(idAuteur);
    }

    @Override
    public List<Livre> findByOrderByNomLivreAsc() {
        return livreRepository.findByOrderByNomLivreAsc();
    }

    @Override
    public List<Livre> trierLivresNomsPrix() {
        return livreRepository.trierLivresNomsPrix();
    }
}
