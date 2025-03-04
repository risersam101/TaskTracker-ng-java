import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { WelcomeDataService } from '../service/data/welcome-data.service';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-welcome',
  imports: [RouterLink,NgIf],
  templateUrl: './welcome.component.html',
  styleUrl: './welcome.component.css'
})
export class WelcomeComponent implements OnInit {
  name=''
  welcomeMessage !:string;
  errorMessage !:string;
  constructor(private route:ActivatedRoute, private welcomeServ:WelcomeDataService){

  }
  ngOnInit() {
   this.name = this.route.snapshot.params['name'];
  }

  getWelcomeMessage(){
    // console.log(this.welcomeServ.executeHelloWorldService());
    this.welcomeServ.executeHelloWorld(this.name).subscribe(
     { next: response=>this.handleSuccessResponse(response),
      error :error=>this.handleErrorResp(error)}
    );
    console.log('last line of getWelcomeMessage..');
  }
  handleErrorResp(error: any): void {
    
    this.errorMessage = error.error.message;
  }

  handleSuccessResponse(response:any){
      // console.log(response.message);
      this.welcomeMessage = response.message;
  }

}
