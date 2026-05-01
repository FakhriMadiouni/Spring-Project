import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { Livre } from '../model/livre.model';
import { Auteur } from '../model/auteur.model';
import { LivreService } from '../services/livre.service';

@Component({
  selector: 'app-update-livre',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './update-livre.component.html',
  styles: ``
})
export class UpdateLivreComponent implements OnInit {

  currentLivre: Livre = {};
  auteurs: Auteur[] = [];
  updatedAuteurId!: number;

  constructor(
    private livreService: LivreService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.livreService.listeAuteurs().subscribe(data => {
      this.auteurs = data;
    });

    const id = this.activatedRoute.snapshot.params['id'];
    this.livreService.getLivreById(id).subscribe(livre => {
      this.currentLivre = livre;
      this.updatedAuteurId = livre.auteur?.idAuteur!;
    });
  }

  updateLivre() {
    this.currentLivre.auteur = this.auteurs.find(a => a.idAuteur == this.updatedAuteurId);
    this.livreService.updateLivre(this.currentLivre).subscribe(() => {
      this.router.navigate(['/livres']);
    });
  }
}
