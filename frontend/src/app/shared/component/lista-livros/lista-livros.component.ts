import {Component, Input, OnChanges, SimpleChanges} from '@angular/core';
import {Livro} from "../../model/livro.model";
import {UserService} from "../../../_services/user.service";

@Component({
    selector: 'lista-livros',
    templateUrl: './lista-livros.component.html',
    styleUrls: ['./lista-livros.component.css']
})
export class ListaLivrosComponent implements OnChanges {
    @Input() livros: Livro[] = [];
    @Input('cols') cols: number = 2;
    dataSource: Livro[] = [];

    constructor(private userService: UserService) {
    }

    ngOnChanges(changes: SimpleChanges): void {
        this.dataSource = changes['livros'].currentValue;
    }

    marcarLivroLido(evento: any, id: number) {
        console.log(evento);
        if (evento) {
            this.userService.marcarLivroLido(id).subscribe(
                {next: () => console.log('retorno marcar livro')}
            );
        } else {
            this.userService.desmarcarLivroLido(id).subscribe(
                {next: () => console.log('retorno desmarcar livro')}
            );
        }
    }
}
