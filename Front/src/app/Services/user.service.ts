import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private readonly apiUrl = 'http://localhost:8080/biblio';

  constructor(private readonly http: HttpClient) { }

  findUser(email: string): Observable<boolean> {
    return this.http.get<boolean>(`${this.apiUrl}/user/findUser`, {
      params: { email }
    });
  }
}
