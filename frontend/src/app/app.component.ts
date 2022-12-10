import {Component, OnInit} from '@angular/core';
import { StorageService } from './_services/storage.service';
import { LoginInfo } from './shared/model/login-info.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'jali';
  isLoggedIn = false;
  user: LoginInfo = new LoginInfo();

  constructor(
    private storageService: StorageService,
  ) { }

  ngOnInit(): void {
    this.isLoggedIn = this.storageService.isLoggedIn();

    if (this.isLoggedIn) {
      this.user = this.storageService.getUser();
    }
  }


}
