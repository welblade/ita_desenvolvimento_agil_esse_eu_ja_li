import {Input, NgModule} from '@angular/core';
import { CommonModule } from '@angular/common';
import {ThumbnailLivroComponent} from "./thumbnail-livro.component";
import {MatCardModule} from "@angular/material/card";
import {MatButtonModule} from "@angular/material/button";
import {Livro} from "../../model/livro.model";
import {ButtonLivroLidoComponent} from "./button-livro-lido/button-livro-lido.component";

@NgModule({
  declarations: [ThumbnailLivroComponent, ButtonLivroLidoComponent],
  imports: [
    CommonModule,
    MatCardModule,
    MatButtonModule
  ],
  exports: [ThumbnailLivroComponent, ButtonLivroLidoComponent]
})
export class ThumbnailLivroModule {}
