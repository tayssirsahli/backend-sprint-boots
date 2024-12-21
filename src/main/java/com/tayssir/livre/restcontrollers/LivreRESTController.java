package com.tayssir.livre.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tayssir.livre.entities.Livre;
import com.tayssir.livre.service.LivreService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class LivreRESTController {

    @Autowired
    LivreService livreService;

    @RequestMapping(path = "all", method = RequestMethod.GET)
    public List<Livre> getAllLivres() {
        return livreService.getAllLivres();
    }

    @RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
    public Livre getLivreById(@PathVariable("id") Long id) {
        return livreService.getLivre(id);
    }

    @RequestMapping(path = "/addlivre", method = RequestMethod.POST)
    public Livre createLivre(@RequestBody Livre livre) {
        return livreService.saveLivre(livre);
    }

    @RequestMapping(path = "/updatelivre", method = RequestMethod.PUT)
    public Livre updateLivre(@RequestBody Livre livre) {
        return livreService.updateLivre(livre);
    }

    @RequestMapping(value = "/dellivre/{id}", method = RequestMethod.DELETE)
    public void deleteLivre(@PathVariable("id") Long id) {
        livreService.deleteLivreById(id);
    }

    @RequestMapping(value = "/livreAuteur/{idAuteur}", method = RequestMethod.GET)
    public List<Livre> getLivresByAuteurId(@PathVariable("idAuteur") Long idAuteur) {
        return livreService.findByAuteur_IdAuteur(idAuteur);
    }

    @RequestMapping(value = "/livresByName/{nom}", method = RequestMethod.GET)
    public List<Livre> findByNomLivreContains(@PathVariable("nom") String nom) {
        return livreService.findByNomLivreContains(nom);
    }
}
