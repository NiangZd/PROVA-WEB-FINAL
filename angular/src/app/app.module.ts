import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatCardModule } from '@angular/material/card';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RegisterComponent } from './register/register.component';
import { LogoutComponent } from './logout/logout.component';
import { DataPagamentoComponent } from './aluno/data-pagamento/data-pagamento.component';
import { FooterComponent } from './aluno/footer/footer.component';
import { InstrutoresComponent } from './aluno/instrutores/instrutores.component';
import { NavbarComponent } from './aluno/navbar/navbar.component';
import { StudentIndexComponent } from './aluno/student-index/student-index.component';
import { VerDadosComponent } from './aluno/ver-dados/ver-dados.component';
import { VerTreinoComponent } from './aluno/ver-treino/ver-treino.component';
import { AdicionarTreinoComponent } from './instrutores/adicionar-treino/adicionar-treino.component';
import { EditarTreinoComponent } from './instrutores/editar-treino/editar-treino.component';
import { FooterInsComponent } from './instrutores/footer/footer.component';
import { GerenciarAlunosComponent } from './instrutores/gerenciar-alunos/gerenciar-alunos.component';
import { InstrutoresIndexComponent } from './instrutores/instrutores-index/instrutores-index.component';
import { ListarTreinosComponent } from './instrutores/listar-treinos/listar-treinos.component';
import { NavbarInsComponent } from './instrutores/navbar/navbar.component';
import { RegisterService } from './services/register.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    LogoutComponent,
    DataPagamentoComponent,
    FooterComponent,
    InstrutoresComponent,
    NavbarComponent,
    StudentIndexComponent,
    VerDadosComponent,
    VerTreinoComponent,
    AdicionarTreinoComponent,
    EditarTreinoComponent,
    FooterInsComponent,
    GerenciarAlunosComponent,
    InstrutoresIndexComponent,
    ListarTreinosComponent,
    NavbarInsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatButtonModule,
    MatFormFieldModule,
    MatCardModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [RegisterService],
  bootstrap: [AppComponent],
})
export class AppModule {}
