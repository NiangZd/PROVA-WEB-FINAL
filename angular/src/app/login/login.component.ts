import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private authService: AuthService
  ) {
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });
  }

  ngOnInit(): void {}

  onSubmit(): void {
    if (this.loginForm.valid) {
      const { email, password } = this.loginForm.value;
      this.authService.loginUser(email, password).subscribe({
        next: (response) => {
          console.log('Login successful', response);
          // O ID do usuário já é armazenado no AuthService
          // Redirecionar ou lidar com a resposta do login conforme necessário
        },
        error: (err) => {
          console.error('Login failed', err);
          // Tratar erros de login
        }
      });
    } else {
      this.checkFormErrors();
    }
  }

  checkFormErrors(): void {
    // Lógica para verificar erros do formulário
  }
}
