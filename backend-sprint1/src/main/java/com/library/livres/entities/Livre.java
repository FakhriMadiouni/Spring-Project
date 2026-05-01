package com.library.livres.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLivre;

    private String titreLivre;
    private Double prixLivre;

    @Temporal(TemporalType.DATE)
    private Date datePublication;

    @ManyToOne
    @JoinColumn(name = "auteur_id")
    private Auteur auteur;
}
