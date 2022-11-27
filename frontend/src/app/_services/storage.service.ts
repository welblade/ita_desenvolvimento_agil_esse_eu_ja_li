import { Injectable } from '@angular/core';
import { UserInfo } from '../shared/model/user-info.model';

const USER_KEY = 'auth-user';

@Injectable({
  providedIn: 'root'
})
export class StorageService {

  clean(): void {
    window.sessionStorage.clear();
  }

  public saveUser(user: UserInfo): void {
    window.sessionStorage.removeItem(USER_KEY);
    window.sessionStorage.setItem(USER_KEY, JSON.stringify(user));
  }

  public getUser(): UserInfo {
    const user = window.sessionStorage.getItem(USER_KEY);
    if (user) {
      return JSON.parse(user) as UserInfo;
    }

    return new UserInfo();
  }

  public isLoggedIn(): boolean {
    let value = window.sessionStorage.getItem(USER_KEY)!;
    const user: UserInfo = JSON.parse(value) as UserInfo;
    if (user) {
      return true;
    }
    return false;
  }
}
