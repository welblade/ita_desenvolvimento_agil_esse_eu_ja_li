import { Component, Input, OnInit } from '@angular/core';
import { UserInfo } from '../model/user-info.model';

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css']
})
export class ToolbarComponent implements OnInit {

  @Input() usuario: UserInfo = new UserInfo();

  constructor() { }

  ngOnInit(): void {
  }
}
