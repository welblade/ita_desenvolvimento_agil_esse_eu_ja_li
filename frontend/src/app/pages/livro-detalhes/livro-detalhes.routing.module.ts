import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LivroDetalhesComponent} from "./livro-detalhes.component";

const routes: Routes = [
  { path: '', component:  LivroDetalhesComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LivroDetalhesRoutingModule { }
