import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const API_URL = 'http://localhost:8080/api/usuarios';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {}

  // TODO: mudar para os métodos da api
  marcarLivroLido(id: number) {
    return this.http.post(`${API_URL}/livros/${id}`, { responseType: 'text' });
  }

  desmarcarLivroLido(id: number) {
    return this.http.delete(`${API_URL}/livros/${id}`, { responseType: 'text' });
  }

}
