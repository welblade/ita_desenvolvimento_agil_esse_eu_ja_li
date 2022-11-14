import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';
import { Livro } from 'src/app/model/livro.model';

@Component({
  selector: 'app-livro-list',
  templateUrl: './livro-list.component.html',
  styleUrls: ['./livro-list.component.css']
})
export class LivroListComponent implements OnChanges {

  @Input() livros: Livro[] = [];
  dataSource: Livro[] = [];
  displayedColumns: string[] = ['id', 'nome', 'paginas', 'categoria', 'isLido'];
  
  constructor() { }
  ngOnChanges(changes: SimpleChanges): void {
    this.dataSource = changes['livros'].currentValue;
  }

}
