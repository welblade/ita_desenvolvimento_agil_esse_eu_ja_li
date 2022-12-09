import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {PerfilComponent} from "./perfil.component";
import {PerfilRoutingModule} from "./perfil.routing.module";
import {MatIconModule} from "@angular/material/icon";
import {MatCardModule} from "@angular/material/card";
import {CardPerfilComponent} from "./card-perfil/card-perfil.component";
@NgModule({
  declarations: [PerfilComponent, CardPerfilComponent],
  imports: [
    CommonModule,
    MatIconModule,
    MatCardModule,
    PerfilRoutingModule
  ],
  exports: [PerfilComponent]
})
export class PerfilModule { }
