import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Auteur } from '../model/auteur.model';
import { LivreService } from '../services/livre.service';

@Component({
  selector: 'app-auteurs',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './auteurs.component.html',
  styles: ``
})
export class AuteursComponent implements OnInit {

  auteurs: Auteur[] = [];
  newAuteur: Auteur = {};
  showForm: boolean = false;

  constructor(private livreService: LivreService) {}

  ngOnInit(): void {
    this.chargerAuteurs();
  }

  chargerAuteurs() {
    this.livreService.listeAuteurs().subscribe(data => {
      this.auteurs = data;
    });
  }

  ajouterAuteur() {
    this.livreService.ajouterAuteur(this.newAuteur).subscribe(() => {
      this.newAuteur = {};
      this.showForm = false;
      this.chargerAuteurs();
    });
  }
}
