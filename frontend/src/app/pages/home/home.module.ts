import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HomeComponent} from "./home.component";
import {ListaLivrosModule} from "../../shared/component/lista-livros/lista-livros.module";
import {HomeRoutingModule} from "./home.routing.module";


@NgModule({
  declarations: [HomeComponent],
  imports: [
    CommonModule,
    ListaLivrosModule,
    HomeRoutingModule
  ],
  exports: [HomeComponent]
})
export class HomeModule {
}
