import { Component } from '@angular/core';
import {MatCard, MatCardContent, MatCardTitle} from "@angular/material/card";

@Component({
  selector: 'app-welcome',
  standalone: true,
  imports: [
    MatCard,
    MatCardContent,
    MatCardTitle
  ],
  templateUrl: './welcome.component.html',
  styleUrl: './welcome.component.css'
})
export class WelcomeComponent {

}
