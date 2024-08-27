// src/app/services/treino.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
  })
  export class TreinoService {
    private apiUrl = 'http://localhost:8080/api/fichas-treino'; // Ajuste a URL da sua API
  
    constructor(private http: HttpClient) {}
  
    addTreino(treinoData: any): Observable<any> {
      // Ajuste o payload conforme necessário
      return this.http.post<any>(this.apiUrl, treinoData);
    }

    getFichasTreino(): Observable<any[]> {
        return this.http.get<any[]>(this.apiUrl);
      }
    
      getFichaTreinoById(id: number): Observable<any> {
        return this.http.get<any>(`${this.apiUrl}/${id}`);
      }
  }
  