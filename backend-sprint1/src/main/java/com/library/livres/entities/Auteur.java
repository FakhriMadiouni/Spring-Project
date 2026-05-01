package com.library.livres.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Auteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAuteur;

    private String nomAuteur;
    private String nationalite;

    @JsonIgnore
    @OneToMany(mappedBy = "auteur", cascade = CascadeType.ALL)
    private List<Livre> livres;
}
