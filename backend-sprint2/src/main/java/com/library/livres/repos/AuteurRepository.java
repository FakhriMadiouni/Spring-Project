package com.library.livres.repos;

import com.library.livres.entities.Auteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "auteurs-rest")
public interface AuteurRepository extends JpaRepository<Auteur, Long> {
}
