import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './_helpers/auth.guard';
import {AppComponent} from "./app.component";

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  {
    path: '',
    loadChildren: () => import('./pages/pages.module').then(m => m.PagesModule),
    canActivate: [AuthGuard]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
