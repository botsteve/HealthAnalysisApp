import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { UserService } from '../services/user.service';
import { MessageService } from 'primeng/api';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  userLogin = new User();

  constructor(protected userService: UserService, protected messageService: MessageService, private router: Router) { }

  ngOnInit() {
  }


  register(newUser: User, isFormValid) {

    if (!isFormValid) {
      this.messageService.add({ severity: 'error', summary: 'Error.' });
      return;
    }
    this.userService.getUserByEmail(this.userLogin.email)
      .subscribe((user) => {
        if (user != null) {
          this.messageService.add({ severity: 'error', summary: 'Email address registered.' });
        } else {
          this.userService.registerUser(this.userLogin).subscribe(() => {
            this.router.navigate(['/login']);
          });

        }
      });

  }


}
