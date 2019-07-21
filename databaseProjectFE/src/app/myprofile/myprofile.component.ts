import { MessageService } from 'primeng/api';
import { UserService } from './../services/user.service';
import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';

@Component({
  selector: 'app-myprofile',
  templateUrl: './myprofile.component.html',
  styleUrls: ['./myprofile.component.css']
})
export class MyprofileComponent implements OnInit {

  userLogin = new User();


  constructor(private userService: UserService, private messageService: MessageService) { }

  ngOnInit() {
    this.userService.getLoggedUser().subscribe(resp => {
      this.userLogin = resp;
      console.log(this.userLogin);
    });

  }

  changeName(firstName?: string, lastName?: string): void {
    console.log(firstName + " " + lastName);

    this.userService.updateUser(firstName, lastName).subscribe(response => {
      console.log(response);
    });
  }



}
