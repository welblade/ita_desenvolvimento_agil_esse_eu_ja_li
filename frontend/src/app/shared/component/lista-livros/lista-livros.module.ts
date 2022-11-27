import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ListaLivrosComponent} from "./lista-livros.component";
import {MatGridListModule} from "@angular/material/grid-list";
import {ThumbnailLivroModule} from "../thumbnail-livro/thumbnail-livro.module";



@NgModule({
  declarations: [ListaLivrosComponent],
  imports: [
    CommonModule,
    MatGridListModule,
    ThumbnailLivroModule,
  ],
  exports: [ListaLivrosComponent]
})
export class ListaLivrosModule { }
