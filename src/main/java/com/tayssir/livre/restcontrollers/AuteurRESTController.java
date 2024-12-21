package com.tayssir.livre.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tayssir.livre.entities.Auteur;
import com.tayssir.livre.repos.AuteurRepository;

@RestController
@RequestMapping("/api/auteurs")
@CrossOrigin("*")
public class AuteurRESTController {

    @Autowired
    AuteurRepository auteurRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Auteur> getAllAuteurs() {
        return auteurRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Auteur getAuteurById(@PathVariable("id") Long id) {
        return auteurRepository.findById(id).orElse(null);
    }
}
