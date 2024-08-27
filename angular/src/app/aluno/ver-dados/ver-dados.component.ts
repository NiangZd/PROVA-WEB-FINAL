import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { VerDadosService } from '../../services/ver-dados.service';
import { UsuarioResponseDto } from '../../models/response.models';

@Component({
  selector: 'app-ver-dados',
  templateUrl: './ver-dados.component.html',
  styleUrls: ['./ver-dados.component.css']
})
export class VerDadosComponent implements OnInit {
  userData?: UsuarioResponseDto;
  userForm: FormGroup;

  constructor(
    private verDadosService: VerDadosService,
    private http: HttpClient,
    private formBuilder: FormBuilder
  ) {
    this.userForm = this.formBuilder.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });
  }

  ngOnInit(): void {
    this.verDadosService.getUserData().subscribe(
      data => {
        this.userData = data;
        this.userForm.patchValue({
          name: this.userData?.name,
          email: this.userData?.email,
          password: '' // Não preencher a senha por questões de segurança
        });
      },
      error => {
        console.error('Erro ao carregar os dados do usuário', error);
      }
    );
  }

  onSubmit(): void {
    if (this.userForm.valid) {
      const updatedData = {
        name: this.userForm.get('name')?.value,
        email: this.userForm.get('email')?.value,
        password: this.userForm.get('password')?.value
      };

      this.http.put('http://localhost:8080/api/usuarios/update', updatedData).subscribe(
        response => {
          console.log('Dados atualizados com sucesso', response);
        },
        error => {
          console.error('Erro ao atualizar os dados', error);
        }
      );
    } else {
      this.checkValidationErrors();
    }
  }

  onDelete(): void {
    if (this.userData?.email) {
      this.http.delete(`http://localhost:8080/api/usuarios/delete/${this.userData.email}`).subscribe(
        response => {
          console.log('Conta excluída com sucesso', response);
          // Redirecionar ou informar o usuário conforme necessário
        },
        error => {
          console.error('Erro ao excluir a conta', error);
        }
      );
    }
  }

  checkValidationErrors(): void {
    const controlErrors = [];

    const nameControl = this.userForm.get('name');
    if (nameControl?.hasError('required')) {
      controlErrors.push('Digite um nome.');
    }

    const emailControl = this.userForm.get('email');
    if (emailControl?.hasError('required')) {
      controlErrors.push('Digite um e-mail.');
    } else if (emailControl?.hasError('email')) {
      controlErrors.push('Digite um e-mail válido.');
    }

    const passwordControl = this.userForm.get('password');
    if (passwordControl?.hasError('required')) {
      controlErrors.push('Digite uma senha.');
    } else if (passwordControl?.hasError('minlength')) {
      controlErrors.push('Senha muito curta.');
    }

    if (controlErrors.length > 0) {
      alert(controlErrors.join('\n'));
    }
  }
}
