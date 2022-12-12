import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Livro } from '../shared/model/livro.model';

const API_URL = 'http://localhost:8080/api/livros/';

@Injectable({
  providedIn: 'root'
})
export class LivrosService {

  constructor(private http: HttpClient) {}

  getTodos(): Observable<Livro[]> {
    return this.http.get<Livro[]>(API_URL, { responseType: 'json' });
  }

  getDetalhes(id : number): Observable<Livro> {
    return this.http.get<Livro>(API_URL + id, { responseType: 'json' });
  }
}
