import {Component, Input, OnInit} from '@angular/core';
import {PerfilUsuario} from "../../../shared/model/perfil-usuario.model";

@Component({
  selector: 'list-trofeu',
  templateUrl: './list-trofeu.component.html',
  styleUrls: ['./list-trofeu.component.css']
})
export class ListTrofeuComponent implements OnInit {
  @Input() perfilUsuario!: PerfilUsuario;
  constructor() {
  }

  ngOnInit(): void {
  }

}
