import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';
import { Livro } from 'src/app/model/livro.model';
import { UserService } from 'src/app/_services/user.service';

@Component({
  selector: 'app-livro-list',
  templateUrl: './livro-list.component.html',
  styleUrls: ['./livro-list.component.css']
})
export class LivroListComponent implements OnChanges {

  @Input() livros: Livro[] = [];
  dataSource: Livro[] = [];
  displayedColumns: string[] = ['id', 'nome', 'paginas', 'categoria', 'isLido'];
  
  constructor(private userService: UserService) { }
  ngOnChanges(changes: SimpleChanges): void {
    this.dataSource = changes['livros'].currentValue;
  }

  marcarLivroLido(evento: any, id: number) {
    if(evento.checked) {
        this.userService.marcarLivroLido(id).subscribe(
          { next: () => console.log('retorno marcar livro') }
        );
    } else {
        this.userService.desmarcarLivroLido(id).subscribe(
          { next: () => console.log('retorno desmarcar livro') }
        );
    }
  }

}
