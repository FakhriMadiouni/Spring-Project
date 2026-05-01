import { Auteur } from "./auteur.model";

export interface Livre {
  idLivre?: number;
  titreLivre?: string;
  prixLivre?: number;
  datePublication?: Date;
  auteur?: Auteur;
}
