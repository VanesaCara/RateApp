import { Component } from '@angular/core';

import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  emailValue: string = "";
  passwordValue: string = "";
  constructor(private http: HttpClient) { }  //back

  sendData() {
    const p = {
      email: this.emailValue,
      password: this.passwordValue
    }
    this.addProduct(p);
  }
  /*
  productData: any = {
    email: this.emailValue,
    password: this.passwordValue
  }
  */
  async addProduct(productData: any) {
    try {
      const res = await this.http.post("http://localhost:8080/login", productData, { responseType: 'text' }).toPromise();

      console.log('Product added successfully:', res);
      alert(res);

    } catch (err: any) {
      alert(err.error);
      console.error('Error adding product:', err);
    }
  }

}
