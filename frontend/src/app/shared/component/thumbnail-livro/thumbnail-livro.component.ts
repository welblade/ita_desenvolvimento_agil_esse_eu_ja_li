import {Component, Input, OnInit} from '@angular/core';
import {Livro} from "../../../model/livro.model";

@Component({
  selector: 'thumbnail-livro',
  templateUrl: './thumbnail-livro.component.html',
  styleUrls: ['./thumbnail-livro.component.css']
})
export class ThumbnailLivroComponent implements OnInit {
  @Input('livro') livro: Livro | null = null;

  constructor() { }

  ngOnInit(): void {
  }

}
