import { Component } from '@angular/core';
import {MatCard, MatCardContent, MatCardModule, MatCardTitle} from "@angular/material/card";
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-welcome',
  standalone: true,
  imports: [
    MatCard,
    MatCardContent,
    MatCardModule,
    MatCardTitle,
    RouterLink
  ],
  templateUrl: './welcome.component.html',
  styleUrl: './welcome.component.css'
})
export class WelcomeComponent {

}
