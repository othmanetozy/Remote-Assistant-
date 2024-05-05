import { Component } from '@angular/core';
import {MatCard, MatCardContent, MatCardModule, MatCardTitle} from "@angular/material/card";

@Component({
  selector: 'app-welcome',
  standalone: true,
  imports: [
    MatCard,
    MatCardContent,
    MatCardModule,
    MatCardTitle
  ],
  templateUrl: './welcome.component.html',
  styleUrl: './welcome.component.css'
})
export class WelcomeComponent {

}
