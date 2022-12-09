import { Component, OnInit } from '@angular/core';
import { StorageService  } from '../../_services/storage.service';
import {UserInfo} from "../../shared/model/user-info.model";

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css']
})
export class PerfilComponent implements OnInit {

  currentUser: UserInfo = new UserInfo();

  constructor(private storageService: StorageService) { }

  ngOnInit(): void {
    this.currentUser = this.storageService.getUser();
  }


}
