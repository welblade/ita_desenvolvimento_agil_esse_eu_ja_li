import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HomeComponent} from "./home.component";
import {ListaLivrosModule} from "../shared/component/lista-livros/lista-livros.module";


@NgModule({
    declarations: [HomeComponent],
    imports: [
        CommonModule,
        ListaLivrosModule
    ],
    exports: [HomeComponent]
})
export class HomeModule {
}
