import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'; // Importa o HttpClient
import { Observable } from 'rxjs';
import { AuthService } from './auth.service'; // Importa o AuthService
import { UsuarioResponseDto } from '../models/response.models'; // Ajuste o caminho conforme necessário

@Injectable({
  providedIn: 'root'
})
export class VerDadosService {
  private apiUrl = 'http://localhost:8080/api/usuarios'; // Substitua pela URL da sua API

  constructor(private authService: AuthService, private http: HttpClient) {}

  // Método para obter os dados do usuário
  getUserData(): Observable<UsuarioResponseDto> {
    const authData = this.authService.getAuthData();
    if (authData && authData.email) {
      return this.http.get<UsuarioResponseDto>(`${this.apiUrl}/dados/${authData.email}`);
    } else {
      throw new Error('Não foi possível obter dados do usuário');
    }
  }

  // Método para atualizar os dados do usuário
  updateUserData(userData: UsuarioResponseDto): Observable<any> {
    const authData = this.authService.getAuthData();
    if (authData && authData.email) {
      return this.http.put(`${this.apiUrl}/atualizar/${authData.email}`, userData);
    } else {
      throw new Error('Não foi possível obter dados do usuário para atualização');
    }
  }
}
