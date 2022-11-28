import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Livro} from "../../model/livro.model";

@Component({
    selector: 'thumbnail-livro',
    templateUrl: './thumbnail-livro.component.html',
    styleUrls: ['./thumbnail-livro.component.css']
})
export class ThumbnailLivroComponent implements OnInit {
    @Input('livro') livro: Livro | null = null;
    @Output() clickJaLido: EventEmitter<any> = new EventEmitter<any>();

    constructor() {
    }

    ngOnInit(): void {
    }
    emitirJaLidoButtonEvent(evento: any) {
        console.log(evento);
        this.clickJaLido.emit(evento);
    }
}
