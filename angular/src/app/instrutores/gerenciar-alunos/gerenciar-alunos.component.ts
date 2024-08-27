import { Component } from '@angular/core';

@Component({
  selector: 'app-gerenciar-alunos',
  templateUrl: './gerenciar-alunos.component.html',
  styleUrls: ['./gerenciar-alunos.component.css'],
})

export class GerenciarAlunosComponent {

  openModal(id: string): void {
    document.getElementById("myModal")!.style.display = "block";
  }

  closeModal(): void {
    document.getElementById("myModal")!.style.display = "none";
  }

}
