import {Component, Input, OnInit} from '@angular/core';
import {UserInfo} from "../../../shared/model/user-info.model";

@Component({
  selector: 'card-perfil',
  templateUrl: './card-perfil.component.html',
  styleUrls: ['./card-perfil.component.css']
})
export class CardPerfilComponent implements OnInit {
  @Input() currentUser: UserInfo = new UserInfo();
  constructor() { }

  ngOnInit(): void {
  }

}
