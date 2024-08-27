import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { AuthResponse, UsuarioResponseDto } from '../models/response.models'; // Ajuste o caminho conforme necessário

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8080/api/usuarios';

  constructor(private http: HttpClient) { }

  loginUser(email: string, password: string): Observable<AuthResponse> {
    return this.http.post<AuthResponse>(`${this.apiUrl}/login`, { email, password }).pipe(
      tap(response => {
        if (response) {
          // Armazenar a resposta inteira em um cookie
          this.setCookie('authResponse', JSON.stringify(response), 1); // Salva um cookie chamado 'authResponse' por 1 dia

          if (response.redirectUrl) {
            window.location.href = response.redirectUrl;
          }
        }
      })
    );
  }

  private setCookie(name: string, value: string, days: number) {
    const expires = new Date();
    expires.setTime(expires.getTime() + (days * 24 * 60 * 60 * 1000));
    const expiresStr = `expires=${expires.toUTCString()}`;
    document.cookie = `${name}=${value};${expiresStr};path=/`;
  }

  getAuthData(): { usuarioId?: number; name?: string; email?: string } | null {
    const cookie = this.getCookie('authResponse');
    if (cookie) {
      try {
        const authData = JSON.parse(cookie);
        return {
          usuarioId: authData.usuarioId,
          name: authData.name,
          email: authData.email // Inclua email
        };
      } catch (e) {
        console.error('Erro ao analisar o cookie:', e);
      }
    }
    return null;
  }

  // Novo método para obter dados do usuário
  getUserData(email: string): Observable<UsuarioResponseDto> {
    return this.http.get<UsuarioResponseDto>(`${this.apiUrl}/dados/${email}`);
  }

  private getCookie(name: string): string | null {
    const nameEQ = `${name}=`;
    const cookies = document.cookie.split(';');
    for (let i = 0; i < cookies.length; i++) {
      let cookie = cookies[i];
      while (cookie.charAt(0) === ' ') cookie = cookie.substring(1);
      if (cookie.indexOf(nameEQ) === 0) return cookie.substring(nameEQ.length);
    }
    return null;
  }
}
