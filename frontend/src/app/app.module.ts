import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http'
import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations'

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {PerfilComponent} from './perfil/perfil.component';
import {httpInterceptorProviders} from './_helpers/http.interceptor';
import {AuthGuard} from './_helpers/auth.guard';
import {UserService} from './_services/user.service';
import {HomeModule} from "./home/home.module";
import {LoginModule} from "./login/login.module";
import {ToolbarModule} from "./shared/component/toolbar/toolbar.module";

@NgModule({
    declarations: [
        AppComponent,
        PerfilComponent,
    ],
    imports: [
        BrowserModule,
        BrowserAnimationsModule,
        AppRoutingModule,
        HttpClientModule,
        ToolbarModule,
        HomeModule,
        LoginModule
    ],
    providers: [httpInterceptorProviders, AuthGuard, UserService],
    bootstrap: [AppComponent]
})
export class AppModule {
}
