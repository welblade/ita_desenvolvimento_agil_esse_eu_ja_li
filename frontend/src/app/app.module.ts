import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http'
import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations'

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {httpInterceptorProviders} from './_helpers/http.interceptor';
import {AuthGuard} from './_helpers/auth.guard';
import {UserService} from './_services/user.service';
import {LoginModule} from "./login/login.module";
import {StorageService} from "./_services/storage.service";

@NgModule({
    declarations: [
        AppComponent,
    ],
    imports: [
        BrowserModule,
        BrowserAnimationsModule,
        AppRoutingModule,
        HttpClientModule,
        LoginModule
    ],
    providers: [
        httpInterceptorProviders,
        AuthGuard,
        UserService,
        StorageService
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
