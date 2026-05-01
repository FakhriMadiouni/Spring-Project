import { HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { AuthService } from './auth.service';

export const tokenInterceptor: HttpInterceptorFn = (req, next) => {
  const authService = inject(AuthService);
  const toExclude = '/login';

  // Ne pas ajouter le header Authorization pour la requête de login
  if (req.url.search(toExclude) === -1) {
    const jwt = authService.getToken();
    if (jwt) {
      const reqWithToken = req.clone({
        setHeaders: { Authorization: 'Bearer ' + jwt }
      });
      return next(reqWithToken);
    }
  }
  return next(req);
};
