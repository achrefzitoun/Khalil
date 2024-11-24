import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/Models/User';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent implements OnInit {

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

}
