import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {MatCardModule} from "@angular/material/card";
import {MatButtonModule} from "@angular/material/button";
import {MatIconModule} from "@angular/material/icon";

import {ButtonLivroLidoComponent} from "./button-livro-lido/button-livro-lido.component";
import {ThumbnailLivroComponent} from "./thumbnail-livro.component";

@NgModule({
    declarations: [ThumbnailLivroComponent, ButtonLivroLidoComponent],
    imports: [
        CommonModule,
        MatCardModule,
        MatButtonModule,
        MatIconModule
    ],
    exports: [ThumbnailLivroComponent, ButtonLivroLidoComponent]
})
export class ThumbnailLivroModule {
}
