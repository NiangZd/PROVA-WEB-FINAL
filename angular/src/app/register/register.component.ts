import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, AbstractControl } from '@angular/forms';
import { ImageLoaderService } from '../image-loader.service';
import { RegisterService } from '../services/register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  logoUrl: string = '';

  constructor(private formBuilder: FormBuilder, private imageLoader: ImageLoaderService, private registerService: RegisterService) {
    this.registerForm = this.formBuilder.group({
      name: ['', [Validators.required]],
      dob: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      confirmPassword: ['', [Validators.required, Validators.minLength(6)]],
      token: ['']
    }, { validator: this.passwordMatchValidator });
  }

  ngOnInit(): void {
    this.loadLogo();
  }

  loadLogo() {
    const logoUrl = 'https://avatars.githubusercontent.com/u/124091983';
    this.imageLoader.loadImage(logoUrl).subscribe((blob: Blob) => {
      this.logoUrl = URL.createObjectURL(blob);
    });
  }

  passwordMatchValidator(control: AbstractControl): { [key: string]: boolean } | null {
    const password = control.get('password');
    const confirmPassword = control.get('confirmPassword');

    if (password && confirmPassword && password.value !== confirmPassword.value) {
      confirmPassword.setErrors({ mismatch: true });
      return { mismatch: true };
    } else {
      confirmPassword?.setErrors(null);
    }
    return null;
  }

  onSubmit(): void {
    if (this.registerForm.valid) {
      const formData = this.registerForm.value;

      // Envia os dados para o backend
      this.registerService.registerUser(formData).subscribe(response => {
        console.log('Usuário registrado com sucesso:', response);
      }, error => {
        console.error('Erro ao registrar usuário:', error);
      });

    } else {
      this.checkValidationErrors(this.registerForm);
    }
  }

  checkValidationErrors(group: FormGroup): void {
    const controlErrors = [];

    if (group.get('name')?.hasError('required')) {
      controlErrors.push('DIGITE UM NOME.');
    }

    if (group.get('dob')?.hasError('required')) {
      controlErrors.push('DIGITE UMA DATA.');
    }

    if (group.get('email')?.hasError('required')) {
      controlErrors.push('DIGITE UM EMAIL.');
    } else if (group.get('email')?.hasError('email')) {
      controlErrors.push('DIGITE UM EMAIL VÁLIDO.');
    }

    if (group.get('password')?.hasError('required')) {
      controlErrors.push('DIGITE UMA SENHA.');
    } else if (group.get('password')?.hasError('minlength')) {
      controlErrors.push('SENHA MUITO CURTA.');
    }

    if (group.get('confirmPassword')?.hasError('required')) {
      controlErrors.push('CONFIRME SUA SENHA.');
    } else if (group.get('confirmPassword')?.hasError('minlength')) {
      controlErrors.push('SENHA DE CONFIRMAÇÃO CURTA.');
    } else if (group.get('confirmPassword')?.hasError('mismatch')) {
      controlErrors.push('SENHAS NÃO IGUAIS.');
    }

    if (controlErrors.length > 0) {
      alert(controlErrors.join('\n'));
    }
  }
}
