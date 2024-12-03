import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/Services/authentication.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit{
  menuVisible: boolean = false;

  constructor(private readonly router: Router, private authServ : AuthenticationService) {}


  ngOnInit(): void {

  }

  toggleMenu() {
    this.menuVisible = !this.menuVisible;
  }
  logout() {
    this.authServ.logout().subscribe(
      response => {
        console.log('Logged out from server');
        localStorage.removeItem('token');
        this.router.navigate(['/login']);
      },
      error => {
        console.error('Failed to logout from server', error);
      }
    );
  }

}
