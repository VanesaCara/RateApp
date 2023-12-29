import { Component } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  emailValue: string = "";
  passwordValue: string = "";

  sendData() {
    console.log(this.emailValue);
    console.log(this.passwordValue);
  }

}
