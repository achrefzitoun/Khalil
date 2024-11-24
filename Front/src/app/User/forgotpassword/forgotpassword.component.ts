import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/Services/user.service';

@Component({
  selector: 'app-forgotpassword',
  templateUrl: './forgotpassword.component.html',
  styleUrls: ['./forgotpassword.component.css']
})
export class ForgotpasswordComponent implements OnInit{

  emailadd!:string;

  constructor(private readonly userService: UserService) { }

  ngOnInit(){

  }

  verifAndSendEmail(){
    this.userService.findUser(this.emailadd).subscribe();
  }
}
