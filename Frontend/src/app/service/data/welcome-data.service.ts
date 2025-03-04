import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class WelcomeDataService {

  constructor(private http:HttpClient) {}

  executeHelloWorldService(){
    return this.http.get<HelloWorldObj>('http://localhost:8080/helloObj');
  }
  
  executeHelloWorld(name:string){

    let basicAuthHeaderString = this.createBasicAuthHeader();
    let headers = new HttpHeaders({
      Authorization:basicAuthHeaderString
    });
    return this.http.get<HelloWorldObj>(`
      http://localhost:8080/hello/${name}`,{
        headers :headers
      });
  }

  createBasicAuthHeader(){
    let username ='user';
    let password = 'dummy'
    let basicAuthHeaderString = 'Basic ' +window.btoa(username + ':' + password);
    return basicAuthHeaderString;
  }
}

export class HelloWorldObj{

  constructor(public message:string){

  }
}