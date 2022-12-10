import { Injectable } from '@angular/core';
import { LoginInfo } from '../shared/model/login-info.model';

const USER_KEY = 'auth-user';

@Injectable({
  providedIn: 'root'
})
export class StorageService {

  clean(): void {
    window.sessionStorage.clear();
  }

  public saveUser(user: LoginInfo): void {
    window.sessionStorage.removeItem(USER_KEY);
    window.sessionStorage.setItem(USER_KEY, JSON.stringify(user));
  }

  public getUser(): LoginInfo {
    const user = window.sessionStorage.getItem(USER_KEY);
    if (user) {
      return JSON.parse(user) as LoginInfo;
    }

    return new LoginInfo();
  }

  public isLoggedIn(): boolean {
    let value = window.sessionStorage.getItem(USER_KEY)!;
    const user: LoginInfo = JSON.parse(value) as LoginInfo;
    return !!user;
  }
}
