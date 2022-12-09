import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AuthGuard} from "../_helpers/auth.guard";
import {PagesComponent} from "./pages.component";

const routes: Routes = [
  { path: '', component: PagesComponent ,
    children: [
      {
        path: 'perfil',
        loadChildren: () => import('./perfil/perfil.module').then(m => m.PerfilModule),
        canActivate: [AuthGuard],
        pathMatch: 'full'
      },
      {
        path: 'home',
        loadChildren: () => import('./home/home.module').then(m => m.HomeModule),
        canActivate: [AuthGuard],
        pathMatch: 'full'
      },
      { path: '', redirectTo: 'home', pathMatch: 'full' },
    ]
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PagesRoutingModule { }
