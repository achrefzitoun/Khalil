import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { RegisterRequest } from '../Models/DTO/auth/RegisterRequest';
import { AuthenticationResponse } from '../Models/DTO/auth/AuthenticationResponse';
import { Observable } from 'rxjs';
import { AuthenticationRequest } from '../Models/DTO/auth/AuthenticationRequest';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http: HttpClient) { }


  register(request: RegisterRequest): Observable<AuthenticationResponse> {
    return this.http.post<AuthenticationResponse>(`http://localhost:8082/biblio/auth/register`, request);
  }

  authentication(request: AuthenticationRequest): Observable<AuthenticationResponse> {
    return this.http.post<AuthenticationResponse>(`http://localhost:8082/biblio/auth/authentication`, request);
  }

  logout(): Observable<void> {
    return this.http.post<void>(`http://localhost:8082/biblio/auth/logout`, {});
  }

  isLoggedIn(): boolean {
    const role = this.getRoleFromToken();
    return role ? true : false;
  }
  
  public getRoleFromToken(): string[] | null {
    const token = localStorage.getItem('token');

    if (token) {
      const payload = token.split('.')[1]; 
      const decodedPayload = atob(payload); 
      const payloadObj = JSON.parse(decodedPayload); 
      
      if (payloadObj && payloadObj.role) {
        return payloadObj.role; 
      }
    }
    return null;
  }
}
