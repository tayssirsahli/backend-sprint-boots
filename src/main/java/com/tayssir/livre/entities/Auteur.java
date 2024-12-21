package com.tayssir.livre.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tayssir.livre.entities.Livre;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Auteur {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAuteur;
    private String nomAuteur;
    private String descriptionAuteur;
    
    @JsonIgnore
    @OneToMany(mappedBy = "auteur")
    private List<Livre> livres;
    
    public Auteur() {
        super();
    }
    
    public Auteur(String nomAuteur, String descriptionAuteur) {
        super();
        this.nomAuteur = nomAuteur;
        this.descriptionAuteur = descriptionAuteur;
    }

    public Long getIdAuteur() {
        return idAuteur;
    }

    public void setIdAuteur(Long idAuteur) {
        this.idAuteur = idAuteur;
    }

    public String getNomAuteur() {
        return nomAuteur;
    }

    public void setNomAuteur(String nomAuteur) {
        this.nomAuteur = nomAuteur;
    }

    public String getDescriptionAuteur() {
        return descriptionAuteur;
    }

    public void setDescriptionAuteur(String descriptionAuteur) {
        this.descriptionAuteur = descriptionAuteur;
    }

    public List<Livre> getLivres() {
        return livres;
    }

    public void setLivres(List<Livre> livres) {
        this.livres = livres;
    }
}
