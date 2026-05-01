import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { Livre } from '../model/livre.model';
import { LivreService } from '../services/livre.service';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-livres',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './livres.component.html',
  styleUrl: './livres.component.css'
})
export class LivresComponent implements OnInit {

  livres: Livre[] = [];
  searchTitre: string = '';

  constructor(
    private livreService: LivreService,
    public authService: AuthService
  ) {}

  ngOnInit(): void {
    this.chargerLivres();
  }

  chargerLivres() {
    this.livreService.listeLivres().subscribe(data => {
      this.livres = data;
    });
  }

  supprimerLivre(livre: Livre) {
    const conf = confirm(`Supprimer "${livre.titreLivre}" ?`);
    if (conf) {
      this.livreService.supprimerLivre(livre.idLivre!).subscribe(() => {
        this.chargerLivres();
      });
    }
  }

  rechercherParTitre(titre: string) {
    if (!titre.trim()) {
      this.chargerLivres();
      return;
    }
    this.livreService.rechercherParTitre(titre).subscribe(data => {
      this.livres = data;
    });
  }
}
