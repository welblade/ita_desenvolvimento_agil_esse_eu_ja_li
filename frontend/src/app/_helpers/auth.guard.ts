import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate,Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

import { StorageService } from '../_services/storage.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(
    private storageService: StorageService,
    private router: Router
  ) {}


  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | boolean{
    if (!this.storageService.isLoggedIn()) {
      this.router.navigate(['/login'])
        .then(() => false);
      return false;
    };
    return true;
  }

}
