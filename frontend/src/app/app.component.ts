import {Component, OnInit} from '@angular/core';
import { StorageService } from './_services/storage.service';
import { UserInfo } from './shared/model/user-info.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'jali';
  private roles: string[] = [];
  isLoggedIn = false;
  showAdminBoard = false;
  showModeratorBoard = false;
  user: UserInfo = new UserInfo();

  constructor(
    private storageService: StorageService,
  ) { }

  ngOnInit(): void {
    this.isLoggedIn = this.storageService.isLoggedIn();

    if (this.isLoggedIn) {
      this.user = this.storageService.getUser();
      this.roles = this.user.autorizacoes;

      this.showAdminBoard = this.roles.includes('ADMIN');
      this.showModeratorBoard = this.roles.includes('USER');
    }
  }


}
