import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RankingRoutingModule } from './ranking-routing.module';
import { RankingComponent } from './ranking.component';
import {MatListModule} from "@angular/material/list";
import {MatIconModule} from "@angular/material/icon";


@NgModule({
  declarations: [
    RankingComponent
  ],
  imports: [
    CommonModule,
    RankingRoutingModule,
    MatListModule,
    MatIconModule
  ]
})
export class RankingModule { }
