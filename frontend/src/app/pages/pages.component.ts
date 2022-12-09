import {Component, Input, OnInit} from '@angular/core';
import {UserInfo} from "../shared/model/user-info.model";
import {StorageService} from "../_services/storage.service";

@Component({
  selector: 'app-pages',
  templateUrl: './pages.component.html',
  styleUrls: ['./pages.component.css']
})
export class PagesComponent implements OnInit {
  user: UserInfo = new UserInfo();
  roles: string[] = [];
  constructor(private storageService: StorageService) { }

  ngOnInit(): void {
    if (this.storageService.isLoggedIn()) {
      this.user = this.storageService.getUser();
      this.roles = this.user.autorizacoes;
    }
  }

}
