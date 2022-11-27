import {Input, NgModule} from '@angular/core';
import { CommonModule } from '@angular/common';
import {ThumbnailLivroComponent} from "./thumbnail-livro.component";
import {MatCardModule} from "@angular/material/card";
import {MatButtonModule} from "@angular/material/button";
import {Livro} from "../../../model/livro.model";

@NgModule({
  declarations: [ThumbnailLivroComponent],
  imports: [
    CommonModule,
    MatCardModule,
    MatButtonModule
  ],
  exports: [ThumbnailLivroComponent]
})
export class ThumbnailLivroModule {}
