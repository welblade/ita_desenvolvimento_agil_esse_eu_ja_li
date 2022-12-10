import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {PerfilComponent} from "./perfil.component";
import {PerfilRoutingModule} from "./perfil.routing.module";
import {MatIconModule} from "@angular/material/icon";
import {MatCardModule} from "@angular/material/card";
import {CardPerfilComponent} from "./card-perfil/card-perfil.component";
import {MatListModule} from "@angular/material/list";
import {ListTrofeuComponent} from "./list-trofeu/list-trofeu.component";
import {ListaLivrosModule} from "../../shared/component/lista-livros/lista-livros.module";
@NgModule({
  declarations: [PerfilComponent, CardPerfilComponent, ListTrofeuComponent],
  imports: [
    CommonModule,
    MatIconModule,
    MatCardModule,
    MatListModule,
    PerfilRoutingModule,
    ListaLivrosModule
  ],
  exports: [PerfilComponent]
})
export class PerfilModule { }
