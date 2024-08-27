import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { RegisterResponse } from '../models/response.models'; // ajuste o caminho conforme necessário

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  private apiUrl = 'http://localhost:8080/api/usuarios/register';

  constructor(private http: HttpClient) { }

  registerUser(userData: any): Observable<RegisterResponse> {
    return this.http.post<RegisterResponse>(this.apiUrl, userData).pipe(
      tap(response => {
        if (response && response.redirectUrl) {
          window.location.href = response.redirectUrl;
        }
      })
    );
  }
}
