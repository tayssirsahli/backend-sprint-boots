package com.tayssir.livre.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tayssir.livre.entities.Auteur;

public interface AuteurRepository extends JpaRepository<Auteur, Long> {

}
