import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {map} from 'rxjs/operators';
import { API_URL } from '../app.constants';
export const TOKEN ='token';
export const AUTHENTICATED_USER='authenticatedUser'

@Injectable({
  providedIn: 'root'
})
export class BasicAuthenticationService {

  constructor(private http:HttpClient) { }

  executeBasicAuth(userName:string, password:string){

      
      let basicAuthHeaderString =  'Basic ' +window.btoa(userName + ':' + password);
      console.log(basicAuthHeaderString);
      let headers = new HttpHeaders({
        Authorization:basicAuthHeaderString
      });

      return this.http.get<AuthObj>(`
        ${API_URL}/basicAuth`,{
          headers :headers
        }).pipe(
          map(
            data =>{
              sessionStorage.setItem(AUTHENTICATED_USER, userName)
              sessionStorage.setItem(TOKEN, basicAuthHeaderString);
              return data;
            }
          )
        );
    }
  
  


  isUserLoggedIn():boolean{
    let user = sessionStorage.getItem(AUTHENTICATED_USER);
    return !(user === null)
  }
  getAuthenticatedUser(){
    return sessionStorage.getItem(AUTHENTICATED_USER);
  }
  
  getAuthToken(){
   if(this.getAuthenticatedUser())
      return sessionStorage.getItem(TOKEN);
    return null;
  }

  logout(){
    sessionStorage.removeItem(AUTHENTICATED_USER);
    sessionStorage.removeItem(TOKEN);
  }
}

export class AuthObj{
  constructor(public message:String){}
}
