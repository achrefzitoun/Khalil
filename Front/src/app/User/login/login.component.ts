import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { AuthenticationRequest } from 'src/app/Models/DTO/auth/AuthenticationRequest';
import { AuthenticationService } from 'src/app/Services/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  constructor(private authServ: AuthenticationService, private router: Router, private messageService: MessageService) { }

  request: AuthenticationRequest = new AuthenticationRequest();

  authentication() {
    this.authServ.authentication(this.request).subscribe(
      response => {
        console.log('hello !', response.token);
        const token = response.token;
        localStorage.setItem('token', token.toString());

        if (token) {
          const role = this.authServ.getRoleFromToken();
          console.log(role)
          if (role && role.includes('ADMIN')) {
            this.router.navigate(['/books']);
          }
          else {
            this.router.navigate(['/booklist']);
          }
        } else {
          this.router.navigate(['/login']);
        }
      },
      error => {
        console.error('Failed to connect', error);
        this.messageService.add({ severity: 'error', summary: 'Refusé', detail: 'E-mail ou mot de passe incorrect' });
      }
    );
  }

}
