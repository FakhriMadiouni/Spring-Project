import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Livre } from '../model/livre.model';
import { Auteur } from '../model/auteur.model';
import { environment } from '../../environments/environment';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class LivreService {

  apiURL: string = environment.apiURL;

  constructor(private http: HttpClient) {}


  
  // ── Livres CRUD ──────────────────────────────────────────────

  // For Sprint 1
  /*
  listeLivres(): Observable<Livre[]> {
    return this.http.get<Livre[]>(this.apiURL);
  }

  getLivreById(id: number): Observable<Livre> {
    return this.http.get<Livre>(`${this.apiURL}/${id}`);
  }

  ajouterLivre(livre: Livre): Observable<Livre> {
    return this.http.post<Livre>(this.apiURL, livre, httpOptions);
  }

  updateLivre(livre: Livre): Observable<Livre> {
    return this.http.put<Livre>(this.apiURL, livre, httpOptions);
  }

  supprimerLivre(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiURL}/${id}`, httpOptions);
  }
  */

  // For Sprint 2
  listeLivres(): Observable<Livre[]> {
    return this.http.get<Livre[]>(this.apiURL + '/all');
  }

  getLivreById(id: number): Observable<Livre> {
    return this.http.get<Livre>(`${this.apiURL}/getbyid/${id}`);
  }

  ajouterLivre(livre: Livre): Observable<Livre> {
    return this.http.post<Livre>(this.apiURL + '/addlivre', livre, httpOptions);
  }

  updateLivre(livre: Livre): Observable<Livre> {
    return this.http.put<Livre>(this.apiURL + '/updatelivre', livre, httpOptions);
  }

  supprimerLivre(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiURL}/dellivre/${id}`, httpOptions);
  }



  // ── Recherche ─────────────────────────────────────────────────
  rechercherParAuteur(idAuteur: number): Observable<Livre[]> {
    return this.http.get<Livre[]>(`${this.apiURL}/livresauteur/${idAuteur}`);
  }

  rechercherParTitre(titre: string): Observable<Livre[]> {
    return this.http.get<Livre[]>(`${this.apiURL}/search/${titre}`);
  }

  // ── Auteurs ───────────────────────────────────────────────────
  listeAuteurs(): Observable<Auteur[]> {
    return this.http.get<Auteur[]>(this.apiURL + '/auteurs');
  }

  ajouterAuteur(auteur: Auteur): Observable<Auteur> {
    return this.http.post<Auteur>(this.apiURL + '/auteurs', auteur, httpOptions);
  }
}
