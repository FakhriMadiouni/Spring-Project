package com.library.livres.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "titreLiv", types = { Livre.class })
public interface LivreProjection {
    public String getTitreLivre();
    public Double getPrixLivre();
}
