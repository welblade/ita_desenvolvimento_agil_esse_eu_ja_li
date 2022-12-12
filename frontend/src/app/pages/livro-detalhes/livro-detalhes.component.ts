import {Component, OnInit} from '@angular/core';
import {Livro} from "../../shared/model/livro.model";
import {ActivatedRoute} from "@angular/router";
import {UserService} from "../../_services/user.service";

@Component({
  selector: 'app-livro-detalhes',
  templateUrl: './livro-detalhes.component.html',
  styleUrls: ['./livro-detalhes.component.css']
})
export class LivroDetalhesComponent implements OnInit {
  livro!: Livro;
  constructor(
    private route: ActivatedRoute,
    private userService: UserService,
    ) { }

  ngOnInit(): void {
    this.livro = this.route.snapshot.data['livro'];
  }

  emitirJaLidoButtonEvent(evento: any) {
    console.log(evento);
    if (this.livro.lido) {
      this.userService.desmarcarLivroLido(this.livro.id).subscribe({
        next: () => {
          console.log('retorno desmarcar livro');
          this.livro.lido = false;
        }
      });

    } else {
      this.userService.marcarLivroLido(this.livro.id).subscribe(
        {next: () => {
          console.log('retorno marcar livro');
          this.livro.lido = false;
        }
      });
    }
  }

}
