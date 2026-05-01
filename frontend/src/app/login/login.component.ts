import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../services/auth.service';
import { User } from '../model/user.model';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styles: ``
})
export class LoginComponent {
  user = new User();
  err: number = 0;

  constructor(private authService: AuthService, private router: Router) {}

  onLoggedin() {
    this.authService.login(this.user).subscribe({
      next: (data) => {
        const jwToken = data.headers.get('Authorization')!;
        this.authService.saveToken(jwToken);
        this.router.navigate(['/']);
      },
      error: () => {
        this.err = 1;
      }
    });
  }
}
