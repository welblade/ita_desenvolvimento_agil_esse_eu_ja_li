import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LivroDetalhesComponent } from './livro-detalhes.component';
import {LivroDetalhesRoutingModule} from "./livro-detalhes.routing.module";
import {ThumbnailLivroModule} from "../../shared/component/thumbnail-livro/thumbnail-livro.module";



@NgModule({
  declarations: [
    LivroDetalhesComponent
  ],
  imports: [
    CommonModule,
    LivroDetalhesRoutingModule,
    ThumbnailLivroModule,
  ],
  exports: [
    LivroDetalhesComponent
  ],
})
export class LivroDetalhesModule { }
