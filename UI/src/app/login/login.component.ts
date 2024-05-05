import {Component, OnInit} from '@angular/core';
import {MatCard, MatCardContent, MatCardHeader, MatCardModule} from "@angular/material/card";
import {RouterLink} from "@angular/router";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators} from "@angular/forms";
import {MatInput} from "@angular/material/input";
import {NgClass} from "@angular/common";

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    MatCard,
    MatCardContent,
    MatCardModule,
    RouterLink,
    MatLabel,
    MatFormField,
    MatCardHeader,
    ReactiveFormsModule,
    FormsModule,
    MatInput,
    NgClass
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit{
  user = {email: "email", password: "password"};
  errorMsg: null = null;
  googleUser = {};

  ngOnInit() {

  }

  // signInWithGoogle() {
  //   this.userService.signInWithGoogle();
  // }

  onSubmit() {
    console.log("email: " + this.user.email + " and password: " + this.user.password);
    // this.userService.login(this.user.email, this.user.password)
    //   .subscribe(
    //     response => {
    //       // doing logic with responce
    //     }
    //     ,
    //     error => {
    //       this.errorMsg = <any>error["message"];
    //     }
    //   );
  }

  signInWithGoogle() {

  }
}
