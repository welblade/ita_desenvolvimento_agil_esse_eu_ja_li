import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, Params, Resolve, RouterStateSnapshot} from '@angular/router';
import {Observable, of} from 'rxjs';
import {Livro} from "../../../shared/model/livro.model";
import {LivrosService} from "../../../_services/livros.service";

@Injectable({
  providedIn: 'root'
})
export class LivroResolverGuard implements Resolve<Livro> {

  constructor(private livroService: LivrosService) {}
  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Livro> {
    const params: Params = route.params;
    if(!params || !params['id'] == null) {
      return of({ id: 0, nome: '', lido: false,categoria: '', paginas: 0});
    }
    return this.livroService.getDetalhes(params['id']);
  }

}
