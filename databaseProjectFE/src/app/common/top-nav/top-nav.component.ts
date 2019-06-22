import { UserService } from './../../services/user.service';
import { Component, OnInit, OnDestroy } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-top-nav',
  templateUrl: './top-nav.component.html',
  styleUrls: ['./top-nav.component.scss']
})
export class TopNavComponent implements OnInit {

  constructor(private userService: UserService, private router:Router) { }

  ngOnInit() {
  }


  signOut(){
    this.userService.updateUserLoggingOut().subscribe(() => {
      this.router.navigate(['/login']);
    });
  }
}
