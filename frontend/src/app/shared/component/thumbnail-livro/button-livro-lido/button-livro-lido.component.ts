import {Component, EventEmitter, Input, Output} from '@angular/core';

@Component({
    selector: 'button-livro-lido',
    templateUrl: './button-livro-lido.component.html',
    styleUrls: ['./button-livro-lido.component.css']
})
export class ButtonLivroLidoComponent {
    @Input() lido: boolean = false;
    @Output() clickJaLido: EventEmitter<any> = new EventEmitter();

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
