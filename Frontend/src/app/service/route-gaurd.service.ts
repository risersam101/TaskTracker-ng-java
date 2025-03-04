import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, GuardResult, MaybeAsync, Router, RouterStateSnapshot } from '@angular/router';
import { HardcodedAuthenticationService } from './hardcoded-authentication.service';

@Injectable({
  providedIn: 'root'
})
export class RouteGaurdService  implements CanActivate{

  constructor(private hardcodedAuthServ:HardcodedAuthenticationService, private router:Router) { }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): MaybeAsync<GuardResult> {
    if(this.hardcodedAuthServ.isUserLoggedIn())
      return true;

    this.router.navigate(["login"]);
    return false;
    
  }
  
}
