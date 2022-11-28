import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
    selector: 'app-button-livro-lido',
    templateUrl: './button-livro-lido.component.html',
    styleUrls: ['./button-livro-lido.component.css']
})
export class ButtonLivroLidoComponent implements OnInit {
    @Input() lido: boolean = false;
    @Output() clickJaLido: EventEmitter<any> = new EventEmitter();
    constructor() {
    }

    ngOnInit(): void {
    }

    processaEvento() {
        this.toggleLido();
        this.emitirEvento();
    }

    toggleLido(){
        this.lido = !this.lido;
    }

    emitirEvento() {
        this.clickJaLido.emit(this.lido);
    }
}
