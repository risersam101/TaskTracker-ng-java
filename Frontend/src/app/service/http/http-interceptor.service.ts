import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BasicAuthenticationService } from '../basic-authentication.service';

@Injectable({
  providedIn: 'root'
})
export class HttpInterceptorService implements HttpInterceptor {

  constructor(private basicAuthSrv: BasicAuthenticationService) { }
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
   
    let basicAuthHeaderString = this.basicAuthSrv.getAuthToken();
    let userName = this.basicAuthSrv.getAuthenticatedUser();
    
    if(basicAuthHeaderString && userName){
      req = req.clone({
      setHeaders:{
        Authorization: basicAuthHeaderString
      }
    });
  }
    return next.handle(req);
  }
}
