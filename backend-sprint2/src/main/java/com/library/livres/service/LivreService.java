package com.library.livres.service;

import com.library.livres.entities.Auteur;
import com.library.livres.entities.Livre;

import java.util.List;

public interface LivreService {
    Livre saveLivre(Livre livre);
    Livre updateLivre(Livre livre);
    void deleteLivreById(Long id);
    Livre getLivre(Long id);
    List<Livre> getAllLivres();
    List<Livre> findByAuteurIdAuteur(Long idAuteur);
    List<Livre> findByTitreLivreContains(String titre);

    Auteur saveAuteur(Auteur auteur);
    List<Auteur> getAllAuteurs();
}
