import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service'; // Ajuste o caminho conforme necessário

@Component({
  selector: 'app-student-index',
  templateUrl: './student-index.component.html',
  styleUrls: ['./student-index.component.css'],
})
export class StudentIndexComponent implements OnInit {
  userName?: string;

  constructor(private authService: AuthService) {}

  ngOnInit(): void {
    const authData = this.authService.getAuthData();
    if (authData && authData.name) {
      this.userName = authData.name;
    }
  }
}
