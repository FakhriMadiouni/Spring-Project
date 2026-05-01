import { Component } from '@angular/core';

@Component({
  selector: 'app-forbidden',
  standalone: true,
  template: `
    <div class="container mt-5">
      <div class="alert alert-danger text-center">
        <h3>🚫 Accès refusé</h3>
        <p>Vous n'avez pas les droits nécessaires pour accéder à cette page.</p>
        <p>Cette fonctionnalité est réservée aux administrateurs.</p>
      </div>
    </div>
  `
})
export class ForbiddenComponent {}
