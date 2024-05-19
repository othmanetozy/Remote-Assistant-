import { Component } from '@angular/core';
import {FormsModule} from "@angular/forms";
import {Router} from "@angular/router";
import {AuthenticationServiceService} from "../../Service/authentication-service.service";

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {
  errorMsg: Array<string> = [];
  authRequest= {email: '', password: ''};
  email: string = ''
  password: string = ''

  constructor(private router : Router,
              private authService:AuthenticationServiceService) {
  }
  login() {
    this.errorMsg = [];
    this.authService.authenticate({
      body : this.authRequest
    }).subscribe({
      next:(=>{

    }
    })
  }

  register() {
    this.router.navigate(['auth/register'])
  }
}
