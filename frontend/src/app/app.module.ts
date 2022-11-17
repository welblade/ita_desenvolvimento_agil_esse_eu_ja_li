import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http' 
import { MatFormFieldModule } from '@angular/material/form-field';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatSliderModule } from '@angular/material/slider';
import { MatGridListModule} from '@angular/material/grid-list';
import { FormsModule } from '@angular/forms';
import { MatTableModule } from '@angular/material/table'
import { MatCardModule } from '@angular/material/card'
import { MatProgressBarModule } from '@angular/material/progress-bar';
import { MatToolbarModule} from'@angular/material/toolbar';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { PerfilComponent } from './perfil/perfil.component';
import { httpInterceptorProviders } from './_helpers/http.interceptor';
import { LivroListComponent } from './home/livro-list/livro-list.component';
import { AuthGuard } from './_helpers/auth.guard';
import { ToolbarComponent } from './toolbar/toolbar.component';
import { MatListModule } from  '@angular/material/list';
import { MatCheckboxModule } from  '@angular/material/checkbox';
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    PerfilComponent,
    LivroListComponent,
    ToolbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatSliderModule,
    MatButtonModule,
    MatInputModule,
    MatGridListModule,
    MatTableModule,
    MatCardModule,
    MatProgressBarModule,
    MatToolbarModule,
    MatListModule,
    MatCheckboxModule,
  ],
  providers: [httpInterceptorProviders, AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
