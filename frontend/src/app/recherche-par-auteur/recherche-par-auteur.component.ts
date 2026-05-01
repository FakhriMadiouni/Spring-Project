import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Livre } from '../model/livre.model';
import { Auteur } from '../model/auteur.model';
import { LivreService } from '../services/livre.service';

@Component({
  selector: 'app-recherche-par-auteur',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './recherche-par-auteur.component.html',
  styles: ``
})
export class RechercheParAuteurComponent implements OnInit {

  auteurs: Auteur[] = [];
  livres: Livre[] = [];
  selectedAuteurId!: number;
  searchNom: string = '';
  hasSearched: boolean = false;

  constructor(private livreService: LivreService) {}

  ngOnInit(): void {
    this.livreService.listeAuteurs().subscribe(data => {
      this.auteurs = data;
    });
  }

  rechercherParAuteur() {
    if (!this.selectedAuteurId) return;
    this.livreService.rechercherParAuteur(this.selectedAuteurId).subscribe(data => {
      this.livres = data;
      this.hasSearched = true;
    });
  }

  rechercherParNom() {
    if (!this.searchNom.trim()) return;
    this.livreService.rechercherParTitre(this.searchNom).subscribe(data => {
      this.livres = data;
      this.hasSearched = true;
    });
  }
}
