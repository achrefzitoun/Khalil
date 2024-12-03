import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegisterRequest } from 'src/app/Models/DTO/auth/RegisterRequest';
import { User } from 'src/app/Models/User';
import { AuthenticationService } from 'src/app/Services/authentication.service';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent implements OnInit {

  constructor( private authServ: AuthenticationService , private datePipe: DatePipe , private router: Router) {
   
   }
  user: User = new User();
  pwdVerif: boolean = false;

  password1 !: string;
  password2 !: string;

  confirmation: boolean = false;

  yearRange!: string;
  maxDate!: Date;

  hasUppercase: boolean = false;
  hasDigit: boolean = false;
  hasSpecialChar: boolean = false;
  isLongEnough: boolean = false;

  request: RegisterRequest = new RegisterRequest();
  passwordValid: boolean = true; 
  repeatedPassword: string = '';
  passwordsMatch: boolean = false;
  passwordTouched: boolean = false;


  birthd!: Date


  ngOnInit(): void {
    const currentYear = new Date().getFullYear();
    this.yearRange = `1900:${currentYear - 17}`;
    this.maxDate = new Date(currentYear - 17, 11, 31);
  }

  verifPwd12(pwd1: string, pwd2: string): void {
    this.pwdVerif = pwd1 === pwd2;
    this.hasUppercase = /[A-Z]/.test(pwd1);
    this.hasDigit = /\d/.test(pwd1);
    this.hasSpecialChar = /[!@#$%^&*()\-_=+{};:,<.>]/.test(pwd1);
    this.isLongEnough = pwd1.length >= 10;
    //this.pwdVerif = this.hasUppercase && this.hasDigit && this.hasSpecialChar && this.isLongEnough && this.pwdMatch;
 
  }

  register() {
    
      const dateconv = this.datePipe.transform(this.birthd, 'yyyy-MM-dd')!;

      this.request.birthDate = dateconv;
      this.request.password = this.password1 ; 
      this.authServ.register(this.request).subscribe(
        response => {
          console.log('Password setup successful', response.token);
          this.router.navigate(['/login']);

        },
        error => {
          console.error('Failed to setup password', error);
        }
      );
    
  }
  validatePassword(password: string): boolean {
    const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
    return passwordRegex.test(password);
  }

  checkPasswordsMatch() {
    this.passwordsMatch = this.request.password === this.repeatedPassword;
  }

  onPasswordInput() {
    this.passwordTouched = true;
    this.passwordValid = this.validatePassword(this.request.password);
  }
}
