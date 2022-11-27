import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { UserInfo } from '../../model/user-info.model';
import { StorageService } from '../../../_services/storage.service';

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css']
})
export class ToolbarComponent {

  @Input() usuario: UserInfo = new UserInfo();

  constructor(private storageService: StorageService, private router: Router) { }

  logOut() {
    this.storageService.clean();
    this.router.navigate(['login'])
  }
}
