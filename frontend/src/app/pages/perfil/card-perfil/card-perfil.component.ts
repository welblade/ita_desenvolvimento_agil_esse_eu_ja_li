import {Component, Input, OnInit} from '@angular/core';
import {PerfilUsuario} from "../../../shared/model/perfil-usuario.model";

@Component({
  selector: 'card-perfil',
  templateUrl: './card-perfil.component.html',
  styleUrls: ['./card-perfil.component.css']
})
export class CardPerfilComponent implements OnInit {
  @Input() perfilUsuario!: PerfilUsuario;
  constructor() { }

  ngOnInit(): void {
  }

}
