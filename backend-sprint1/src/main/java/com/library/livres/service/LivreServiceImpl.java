package com.library.livres.service;

import com.library.livres.entities.Auteur;
import com.library.livres.entities.Livre;
import com.library.livres.repos.AuteurRepository;
import com.library.livres.repos.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LivreServiceImpl implements LivreService {

    @Autowired
    LivreRepository livreRepository;

    @Autowired
    AuteurRepository auteurRepository;

    @Override
    public Livre saveLivre(Livre livre) {
        return livreRepository.save(livre);
    }

    @Override
    public Livre updateLivre(Livre livre) {
        return livreRepository.save(livre);
    }

    @Override
    public void deleteLivreById(Long id) {
        livreRepository.deleteById(id);
    }

    @Override
    public Livre getLivre(Long id) {
        return livreRepository.findById(id).orElse(null);
    }

    @Override
    public List<Livre> getAllLivres() {
        return livreRepository.findAll();
    }

    @Override
    public List<Livre> findByAuteurIdAuteur(Long idAuteur) {
        return livreRepository.findByAuteurIdAuteur(idAuteur);
    }

    @Override
    public List<Livre> findByTitreLivreContains(String titre) {
        return livreRepository.findByTitreLivreContains(titre);
    }

    @Override
    public Auteur saveAuteur(Auteur auteur) {
        return auteurRepository.save(auteur);
    }

    @Override
    public List<Auteur> getAllAuteurs() {
        return auteurRepository.findAll();
    }
}
