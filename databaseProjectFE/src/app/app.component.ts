import { User } from './model/user';
import { UserService } from './services/user.service';
import { Component, OnDestroy, HostListener } from '@angular/core';
import { logging } from 'protractor';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{

  title = 'databaseProjectFE';

  constructor(private userService: UserService) {
  }


  @HostListener('window:beforeunload', ['$event'])
    public doUnload($event) {
      this.userService.updateUserLoggingOut().subscribe();
  }
}
