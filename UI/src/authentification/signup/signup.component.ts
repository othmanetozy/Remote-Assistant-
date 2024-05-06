import {Component, ElementRef} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {NgClass} from "@angular/common";

@Component({
  selector: 'app-signup',
  standalone: true,
  imports: [
    FormsModule,
    ReactiveFormsModule,
    NgClass
  ],
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent {
  user = {email: "email", password: "password", name : "name"};
  passwordFieldType = "password";

  constructor(private elementRef: ElementRef) {}

  onSubmit() {
    return false;
  }

  togglePasswordVisibility() {
    const passwordInput = this.elementRef.nativeElement.querySelector('input[type="password"]');
    this.passwordFieldType = this.passwordFieldType === 'password' ? 'text' : 'password';
    passwordInput.type = this.passwordFieldType;
  }
}
