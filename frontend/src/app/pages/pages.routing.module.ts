import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AuthGuard} from "../_helpers/auth.guard";
import {PagesComponent} from "./pages.component";
import {LivroResolverGuard} from "./shared/guard/livro-resolver-guard.service";

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
      {
        path: 'ranking',
        loadChildren: () => import('./ranking/ranking.module').then(m => m.RankingModule),
        canActivate: [AuthGuard],
        pathMatch: 'full'
      },
      {
        path: 'livros/:id',
        loadChildren: () => import('./livro-detalhes/livro-detalhes.module').then(m => m.LivroDetalhesModule),
        canActivate: [AuthGuard],
        resolve: { livro: LivroResolverGuard },
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
