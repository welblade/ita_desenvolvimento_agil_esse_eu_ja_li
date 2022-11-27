import { Component, OnInit } from '@angular/core';
import { Livro } from '../shared/model/livro.model';
import { LivrosService } from '../_services/livros.service';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  content: Livro[] = [];

  constructor(private service: LivrosService) { }

  ngOnInit(): void {
    this.service.getTodos().subscribe({
      next: (data: any) => {
        this.content = data;
      },
      error: err => {console.log(err)
        if (err.error) {
          this.content = JSON.parse(err.error).message;
        } else {
          console.error("Error with status: " + err.status);
        }
      }
    });
  }

}
