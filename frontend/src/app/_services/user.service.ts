import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {PerfilUsuario} from "../shared/model/perfil-usuario.model";
import {Usuario} from "../shared/model/usuario.model";

const API_URL = 'http://localhost:8080/api/usuarios';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {}

  marcarLivroLido(id: number) {
    return this.http.post(`${API_URL}/livros/${id}`, { responseType: 'text' });
  }

  desmarcarLivroLido(id: number) {
    return this.http.delete(`${API_URL}/livros/${id}`, { responseType: 'text' });
  }

  obterMeuPerfil(): Observable<PerfilUsuario> {
    return this.http.get<PerfilUsuario>(`${API_URL}/perfil`, { responseType: 'json' });
  }

  obterRanking(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(`${API_URL}/ranking`, { responseType: 'json' });
  }

}
