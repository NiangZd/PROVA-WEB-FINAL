import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service'; // ajuste o caminho conforme necessário

@Component({
  selector: 'app-instrutores-index',
  templateUrl: './instrutores-index.component.html',
  styleUrls: ['./instrutores-index.component.css']
})
export class InstrutoresIndexComponent implements OnInit {
  usuarioId?: number;
  name?: string;

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
    const authData = this.authService.getAuthData();
    if (authData) {
      this.usuarioId = authData.usuarioId;
      this.name = authData.name;
    }
  }
}
