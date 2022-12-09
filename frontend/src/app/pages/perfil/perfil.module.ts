import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {PerfilComponent} from "./perfil.component";
import {PerfilRoutingModule} from "./perfil.routing.module";
@NgModule({
  declarations: [PerfilComponent],
  imports: [
    CommonModule,
    PerfilRoutingModule
  ],
  exports: [PerfilComponent]
})
export class PerfilModule { }
