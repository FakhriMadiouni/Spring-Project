package com.library.livres;

import com.library.livres.entities.Auteur;
import com.library.livres.entities.Livre;
import com.library.livres.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class LivresApiApplication implements CommandLineRunner {

    @Autowired
    LivreService livreService;

    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(LivresApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Expose IDs for Spring Data REST
        repositoryRestConfiguration.exposeIdsFor(Livre.class);
        repositoryRestConfiguration.exposeIdsFor(Auteur.class);

        // Seed data
        Auteur a1 = livreService.saveAuteur(new Auteur(null, "Victor Hugo", "Française", null));
        Auteur a2 = livreService.saveAuteur(new Auteur(null, "Gabriel García Márquez", "Colombienne", null));
        Auteur a3 = livreService.saveAuteur(new Auteur(null, "Tahar Ben Jelloun", "Marocaine", null));

        livreService.saveLivre(new Livre(null, "Les Misérables", 29.99, new Date(), a1));
        livreService.saveLivre(new Livre(null, "Notre-Dame de Paris", 24.50, new Date(), a1));
        livreService.saveLivre(new Livre(null, "Cent ans de solitude", 32.00, new Date(), a2));
        livreService.saveLivre(new Livre(null, "L'Amour aux temps du choléra", 27.90, new Date(), a2));
        livreService.saveLivre(new Livre(null, "La Nuit sacrée", 18.00, new Date(), a3));
        livreService.saveLivre(new Livre(null, "L'Enfant de sable", 15.50, new Date(), a3));
    }
}
