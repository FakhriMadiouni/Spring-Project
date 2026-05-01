package com.library.livres.restcontrollers;

import com.library.livres.entities.Livre;
import com.library.livres.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class LivreRESTController {

    @Autowired
    LivreService livreService;

    @GetMapping
    public List<Livre> getAllLivres() {
        return livreService.getAllLivres();
    }

    @GetMapping("/{id}")
    public Livre getLivreById(@PathVariable("id") Long id) {
        return livreService.getLivre(id);
    }

    @PostMapping
    public Livre createLivre(@RequestBody Livre livre) {
        return livreService.saveLivre(livre);
    }

    @PutMapping
    public Livre updateLivre(@RequestBody Livre livre) {
        return livreService.updateLivre(livre);
    }

    @DeleteMapping("/{id}")
    public void deleteLivre(@PathVariable("id") Long id) {
        livreService.deleteLivreById(id);
    }

    @GetMapping("/livresauteur/{idAuteur}")
    public List<Livre> getLivresByAuteur(@PathVariable("idAuteur") Long idAuteur) {
        return livreService.findByAuteurIdAuteur(idAuteur);
    }

    @GetMapping("/search/{titre}")
    public List<Livre> searchByTitre(@PathVariable("titre") String titre) {
        return livreService.findByTitreLivreContains(titre);
    }
}
