import { Component, OnInit } from '@angular/core';
import {UserService} from "../../_services/user.service";
import {Usuario} from "../../shared/model/usuario.model";
import {Observable, take} from "rxjs";

@Component({
  selector: 'app-ranking',
  templateUrl: './ranking.component.html',
  styleUrls: ['./ranking.component.css']
})
export class RankingComponent implements OnInit {
  ranking!: Observable<Usuario[]>;
  constructor(private service: UserService) { }

  ngOnInit(): void {
    this.ranking = this.service.obterRanking()
      .pipe(take(1))
  }

}
