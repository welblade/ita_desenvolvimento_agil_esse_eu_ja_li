import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { LoginInfo } from '../../model/login-info.model';
import { StorageService } from '../../../_services/storage.service';

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css']
})
export class ToolbarComponent {

  @Input() usuario: LoginInfo = new LoginInfo();

  constructor(private storageService: StorageService, private router: Router) { }

  logOut() {
    this.storageService.clean();
    this.router.navigate(['login'])
  }
}
