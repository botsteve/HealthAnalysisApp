import { MessageService } from 'primeng/api';
import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { UserService } from '../services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  userLogin = new User();
  auxUser = new User();

  constructor(protected userService: UserService, protected messageService: MessageService, private router:Router) {

  }

  checkUser(isFormValid): void {

    if (!isFormValid) {
      this.messageService.add({ severity: 'error', summary: 'Error.' });
      return;
    }

    this.userService.getUserByEmail(this.userLogin.email)
        .subscribe((user) => {
          if (user == null) {
            this.messageService.add({ severity: 'error', summary: 'Email address not registered.' });
            return;
          } else {
            if (user.password != this.userLogin.password) {
              this.messageService.add({ severity: 'error', summary: 'Incorrect password' });
              return;
            } else {
              let form = document.querySelector("form");
              this.messageService.add({ severity: 'success', summary: 'Login successful' });



              this.userService.getUserByEmail(this.userLogin.email).subscribe(user => {
                this.userService.updateUserLoggedIn(this.userLogin.email);
              })
              this.router.navigate(['/home']);
            }
          }
        });
  }

  ngOnInit() {
  }

}
