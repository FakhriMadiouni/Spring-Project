package com.library.livres.repos;

import com.library.livres.entities.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "rest")
public interface LivreRepository extends JpaRepository<Livre, Long> {

    List<Livre> findByTitreLivreContains(@Param("titre") String titre);
    List<Livre> findByAuteurIdAuteur(@Param("idAuteur") Long idAuteur);
}
