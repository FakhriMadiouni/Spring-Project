import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { Livre } from '../model/livre.model';
import { Auteur } from '../model/auteur.model';
import { LivreService } from '../services/livre.service';

@Component({
  selector: 'app-add-livre',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './add-livre.component.html',
  styles: ``
})
export class AddLivreComponent implements OnInit {

  newLivre: Livre = {};
  auteurs: Auteur[] = [];
  selectedAuteurId!: number;

  constructor(private livreService: LivreService, private router: Router) {}

  ngOnInit(): void {
    this.livreService.listeAuteurs().subscribe(data => {
      this.auteurs = data;
    });
  }

  addLivre() {
    this.newLivre.auteur = this.auteurs.find(a => a.idAuteur == this.selectedAuteurId);
    this.livreService.ajouterLivre(this.newLivre).subscribe(() => {
      this.router.navigate(['/livres']);
    });
  }
}
