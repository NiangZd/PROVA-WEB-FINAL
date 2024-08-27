import { Component } from '@angular/core';

@Component({
  selector: 'app-listar-treinos',
  templateUrl: './listar-treinos.component.html',
  styleUrls: ['./listar-treinos.component.css']
})
export class ListarTreinosComponent {

  openModal(id: string): void {
    document.getElementById("myModal")!.style.display = "block";
  }

  closeModal(): void {
    document.getElementById("myModal")!.style.display = "none";
  }

}
