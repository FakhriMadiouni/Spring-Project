package com.library.livres.restcontrollers;

import com.library.livres.entities.Auteur;
import com.library.livres.repos.AuteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auteurs")
@CrossOrigin("*")
public class AuteurRESTController {

    @Autowired
    AuteurRepository auteurRepository;

    @GetMapping
    public List<Auteur> getAllAuteurs() {
        return auteurRepository.findAll();
    }

    @GetMapping("/{id}")
    public Auteur getAuteurById(@PathVariable("id") Long id) {
        return auteurRepository.findById(id).get();
    }

    @PostMapping
    public Auteur createAuteur(@RequestBody Auteur auteur) {
        return auteurRepository.save(auteur);
    }
}
