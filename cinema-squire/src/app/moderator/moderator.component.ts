import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ApiClientService } from '../api-client.service';
import { DataServiceService } from '../data-service.service'
import { Router } from '@angular/router';

@Component({
  selector: 'app-moderator',
  templateUrl: './moderator.component.html',
  styleUrls: ['./moderator.component.scss']
})
export class ModeratorComponent implements OnInit {
  users: any;
  img: any;
  searchUser: any;
  user: any;

  constructor(private dataService: DataServiceService, private service: ApiClientService, private router: Router) { }

  userSearch(form: NgForm) {
    this.service.getAllUsers().subscribe((data) => {
      this.users = data;
      for (let i = 0; i < this.users.length; i++){
        if (form.value.usernameInput == this.users[i].username) {
          this.searchUser = this.users[i];
        }
      }
    })
  }



  banUser(id) {
    this.service.deleteUser(id).subscribe((data) => {
    })
  }

  promoteToMod(id) {
    this.service.changeUserRole(id, "MODERATOR").subscribe((data) => {
    })
  }

  removeMod(id){
    this.service.changeUserRole(id, "USER").subscribe((data) => {
    })
  }

  ngOnInit() {
    this.user = this.dataService.getUser();
    if (this.user == null) {
      this.router.navigateByUrl('/');
    }
  }

}