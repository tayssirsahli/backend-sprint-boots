package com.tayssir.cosmetique.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
public class Classification {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idClas;
    private String nomClas;
    private String descriptionClas;
    
    @JsonIgnore
    @OneToMany(mappedBy = "classification")
    private List<Cosmetique> cosmetiques;
	
    public Classification() {
		super();
	}
    
	public Classification(String nomClas, String descriptionClas) {
		super();
		this.nomClas = nomClas;
		this.descriptionClas = descriptionClas;

	}

	public Long getIdClas() {
		return idClas;
	}

	public void setIdClas(Long idClas) {
		this.idClas = idClas;
	}

	public String getNomClas() {
		return nomClas;
	}

	public void setNomClas(String nomClas) {
		this.nomClas = nomClas;
	}

	public String getDescriptionClas() {
		return descriptionClas;
	}

	public void setDescriptionClas(String descriptionClas) {
		this.descriptionClas = descriptionClas;
	}

	public List<Cosmetique> getCosmetiques() {
		return cosmetiques;
	}

	public void setCosmetiques(List<Cosmetique> cosmetiques) {
		this.cosmetiques = cosmetiques;
	}
    
    
    
    
    
}

