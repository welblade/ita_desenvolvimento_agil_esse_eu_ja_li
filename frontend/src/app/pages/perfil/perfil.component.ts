import { Component, OnInit } from '@angular/core';
import {UserService} from "../../_services/user.service";
import {PerfilUsuario} from "../../shared/model/perfil-usuario.model";
import {take} from "rxjs";

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css']
})
export class PerfilComponent implements OnInit {
  isLogged = false;
  perfilUsuario!: PerfilUsuario;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.userService.obterMeuPerfil()
      .pipe(take<PerfilUsuario>(1))
      .subscribe({
        next: perfil => {
          this.perfilUsuario = perfil;
          this.isLogged = true;
        },
        error: error => console.error(error)
      });
  }


}
