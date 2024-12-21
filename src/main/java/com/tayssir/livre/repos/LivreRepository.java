package com.tayssir.livre.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tayssir.livre.entities.Livre;
import com.tayssir.livre.entities.Auteur;

@RepositoryRestResource(path = "rest")
public interface LivreRepository extends JpaRepository<Livre, Long> {

    List<Livre> findByNomLivre(String nomLivre);

    List<Livre> findByNomLivreContains(String nomLivre);

    @Query("select l from Livre l where l.auteur = ?1")
    List<Livre> findByAuteur(Auteur auteur);

    List<Livre> findByAuteur_IdAuteur(long idAuteur);

    List<Livre> findByOrderByNomLivreAsc();

    @Query("select l from Livre l order by l.nomLivre ASC, l.prixLivre DESC")
    List<Livre> trierLivresNomsPrix();
}
