import { Routes } from '@angular/router';
import {WelcomeComponent} from "./welcome/welcome.component";
import {LoginComponent} from "../authentification/login/login.component";
import {SignupComponent} from "../authentification/signup/signup.component";

export const routes: Routes = [
  { path: '', component: WelcomeComponent},
  {path : "login" , component : LoginComponent},
  {path : "signup" , component: SignupComponent}

];
