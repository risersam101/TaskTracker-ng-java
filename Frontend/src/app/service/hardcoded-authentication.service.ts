import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HardcodedAuthenticationService {

  constructor() { }

  authenticate(userName:string, password:string):boolean{
    
    if(userName=='Sam' && password=='bruv'){
      sessionStorage.setItem('authenticatedUser', userName);
      return true;
    }
    
    return false;
  }

  isUserLoggedIn():boolean{
    let user = sessionStorage.getItem('authenticatedUser');
    return !(user === null)
  }

  logout(){
    sessionStorage.removeItem('authenticatedUser');
  }
}
