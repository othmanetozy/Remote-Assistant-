import { Routes } from '@angular/router';
import {WelcomeComponent} from "./welcome/welcome.component";
import {LoginComponent} from "./authentification/login/login.component";
import {SignupComponent} from "./authentification/signup/signup.component";
import {DashbordComponent} from "./dashbord/dashbord.component";


export const routes: Routes = [
  { path: '', component: WelcomeComponent},
  {path : "login" , component : LoginComponent},
  {path : "signup" , component: SignupComponent},
  { path: 'dashboard', component: DashbordComponent }
];
