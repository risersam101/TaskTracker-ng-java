import { NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { HardcodedAuthenticationService } from '../service/hardcoded-authentication.service';
import { BasicAuthenticationService } from '../service/basic-authentication.service';

@Component({
  selector: 'app-login',
  imports: [FormsModule, NgIf

  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  userName!: string;
  password !: string;
  errorMessage = 'Invalid Credentials!';
  invalidLogin = false;


  constructor(private router: Router,
    private hardCodedAuthSrv: HardcodedAuthenticationService,
    private basicAuthSrv: BasicAuthenticationService,
  ) { }



  handleLogin(): void {

    if (this.hardCodedAuthSrv.authenticate(this.userName, this.password)) {
      this.invalidLogin = false;
      this.router.navigate(['welcome' + '/' + this.userName]);
    } else {
      this.invalidLogin = true;
    }
    console.log('Valid User =>' + !this.invalidLogin);
  }


  handleBasicAuth(): void {

    this.basicAuthSrv.executeBasicAuth(this.userName,this.password).subscribe({
      next: data=>{
        console.log(data);
        this.invalidLogin = false;
      this.router.navigate(['welcome' + '/' + this.userName]);

      },
      error: error=>{
        this.invalidLogin = true;
        console.log("Somethin wrong bruv! check cred..."+error)
  }});
  }
}
