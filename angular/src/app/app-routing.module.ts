import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
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
import { GerenciarAlunosComponent } from './instrutores/gerenciar-alunos/gerenciar-alunos.component';
import { InstrutoresIndexComponent } from './instrutores/instrutores-index/instrutores-index.component';
import { ListarTreinosComponent } from './instrutores/listar-treinos/listar-treinos.component';


const routes: Routes = [
  {
    path: '',
    component: LoginComponent,
  },
  {
    path: 'register',
    component: RegisterComponent,
  },
  {
    path: 'logout',
    component: LogoutComponent,
  },
  {
    path: 'data-pagamento',
    component: DataPagamentoComponent,
  },
  {
    path: 'footer',
    component: FooterComponent,
  },
  {
    path: 'instrutores',
    component: InstrutoresComponent,
  },
  {
    path: 'navbar',
    component: NavbarComponent,
  },
  {
    path: 'student',
    component: StudentIndexComponent,
  },
  {
    path: 'ver-dados',
    component: VerDadosComponent,
  },
  {
    path: 'ver-treino',
    component: VerTreinoComponent,
  },
  {
    path: 'adicionar-treino',
    component: AdicionarTreinoComponent,
  },
  {
    path: 'editar-treino',
    component: EditarTreinoComponent,
  },
  {
    path: 'gerenciar-alunos',
    component: GerenciarAlunosComponent,
  },
  {
    path: 'instrutores-index',
    component: InstrutoresIndexComponent,
  },
  {
    path: 'listar-treinos',
    component: ListarTreinosComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
