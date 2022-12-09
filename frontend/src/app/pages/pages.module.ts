import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {PagesComponent} from './pages.component';
import {RouterModule} from "@angular/router";
import {ToolbarModule} from "../shared/component/toolbar/toolbar.module";
import {PagesRoutingModule} from "./pages.routing.module";

@NgModule({
  declarations: [
    PagesComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    ToolbarModule,
    PagesRoutingModule
  ]
})
export class PagesModule {
}
